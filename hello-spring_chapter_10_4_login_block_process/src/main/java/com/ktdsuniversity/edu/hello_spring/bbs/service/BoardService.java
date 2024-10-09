package com.ktdsuniversity.edu.hello_spring.bbs.service;

import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.ModifyBoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.WriteBoardVO;

public interface BoardService {

	public BoardListVO getAllBoard();
	
	public boolean creatNewBoard(WriteBoardVO writeBoardVO); // 성공했냐 실패했냐를 알기위해 boolean으로 사용.
	
	public BoardVO updateOneBoard(int id, boolean isIncrease);
	
	public boolean updateModifyOneBoard(ModifyBoardVO modifyBoardVO);
	
	public boolean deleteOneBoard(int id);
}
