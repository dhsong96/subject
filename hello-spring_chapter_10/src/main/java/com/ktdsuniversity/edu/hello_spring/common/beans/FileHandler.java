package com.ktdsuniversity.edu.hello_spring.common.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.edu.hello_spring.common.vo.StoreResultVO;

/**
 * @Component => Spring Bean으로 생성해라!
 */
@Component
public class FileHandler {

	@Value("${app.multipart.base-dir}")
	private String baseDirectory;
	
	@Value("${app.multipart.obfuscation.enable}")
	private boolean enableObfuscation;
	
	@Value("${app.multipart.obfuscation.hide-ext.enable}")
	private boolean enableHideExtention;
	
	// 업로드
	public StoreResultVO storeFile(MultipartFile multipartFile) {
		// 1. 클라이언트가 파일을 전송했는지 확인.
		// 2. 클라이언트가 파일을 전송했다면
		if (multipartFile != null && !multipartFile.isEmpty()) {
			// 3. 파일을 서버 컴퓨터의 특정 폴더로 저장시킨다. 
			String obfuscatedFileName = multipartFile.getOriginalFilename();
			
			if(this.enableObfuscation) {
				
				String ext = obfuscatedFileName.substring(obfuscatedFileName.lastIndexOf("."));
				
				obfuscatedFileName = UUID.randomUUID().toString();
				
				if(!this.enableHideExtention) {
					obfuscatedFileName += ext;
				}
			}
			
			// 파라미터엔 파일이 전송될 위치를 적어준다.
			
			File uploadFile = new File(this.baseDirectory, obfuscatedFileName); // 사용자가 보내준 파일 이름:file.getOriginalFilename() 이 이름을 못쓰게 해야한다. 난독화.
			// 파일이 없다면 파일을 만들어라.
			if(!uploadFile.getParentFile().exists()) {
				uploadFile.getParentFile().mkdirs();
			}
			try {
				multipartFile.transferTo( uploadFile );
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				throw new RuntimeException("예기치 못한 이유로 업로드에 실패했습니다. 잠시 후 다시 시도해주세요.");
			}
			
			return new StoreResultVO(multipartFile.getOriginalFilename(), obfuscatedFileName);
		}
		return null;
	}
	
	// 다운로드
	public ResponseEntity<Resource> downloadFile(String fileName, String originFileName) {
		// 2. 다운로드 할 파일의 정보를 가지고 있는 File인스턴스를 생성한다.
		File downloadFile = new File(this.baseDirectory, fileName);
		
		// 3. HTTP Header에 파일 다운로드 정보를 설정한다.
		HttpHeaders header = new HttpHeaders();
		
		// 다운로드 시킬 파일 이름의 인코딩을 변경한다.
		// 파일 다운로드에 대해서만 이 코드를 작성해야한다.
		try {
			originFileName = new String(originFileName.getBytes("UTF-8"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
			// HTTP Response에 파일을 첨부해서 보낼건데 파일의 이름은 "~~~" 이야~
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename = " + originFileName);
		// 4. 브라우저에게 파일을 전송한다.
		InputStreamResource resource = null;
		try {
			resource = new InputStreamResource(new FileInputStream(downloadFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("파일이 존재하지 않습니다.");
		}
		
		// 브라우저에게 보낼 응답 데이터를 생성한다.
		return ResponseEntity.ok()
							// 응답 데이터에 http header 정보를 셋팅한다 ( 파일다운로드 정보 )
							 .headers(header)
							 // 다운로드 시킬 파일의 크기를 전달한다. - 브라우저가 파일 다운로드 진행 상태를 관리하기 위해서.
							 .contentLength(downloadFile.length())
							 // 다운로드 시킬 파일의 타입을 지정한다.
							 // 보통 png 파일이라면 image/png 이렇게 지정하는데
							 // 타입과 관계없이 강제 다운로드를 시키려면 "application/octet-stream" 을 이용한다.
							 .contentType(MediaType.parseMediaType("application/octet-stream"))
							 // 파일을 응답데이터에 전달한다.
							 .body(resource);
	}
	// 삭제
	public void deleteFile(String fileName) {
		
		if(fileName == null) {
			return;
		}
		
		File file = new File(this.baseDirectory, fileName);
		
		if(file.exists() && file.isFile()) {
			file.delete();
		}
	}
	
}
