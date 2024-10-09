package com.ktdsuniversity.edu.hello_spring.common.vo;

public class StoreResultVO {

	private String originFileName;
	private String obfuscatedFileName;
	
	// 마음대로 바뀌어선 안되므로 setter 생성하지 않고 생성자를 만들어줌.
	public StoreResultVO(String originFileName, String obfuscatedFileName) {
		this.originFileName = originFileName;
		this.obfuscatedFileName = obfuscatedFileName;
	}
	
	public String getOriginFileName() {
		return originFileName;
	}
	
	public String getObfuscatedFileName() {
		return obfuscatedFileName;
	}
	
}
