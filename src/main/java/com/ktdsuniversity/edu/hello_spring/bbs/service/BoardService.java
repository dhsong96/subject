package com.ktdsuniversity.edu.hello_spring.bbs.service;

import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.WriteBoardVO;

public interface BoardService {

	public BoardListVO getAllBoard();
	
	public boolean creatNewBoard(WriteBoardVO writeBoardVO); // 성공했냐 실패했냐를 알기위해 boolean으로 사용.
	
	/**
	 * 파라미터로 전달받은 id로 게시글을 조회한다.
	 * 게시글 조회시 조회수도 1 증가한다.
	 * @param id : 조회할 게시글의 ID
	 * @return : 게시글 정보
	 */
	public BoardVO getOneBoard(int id);
}
