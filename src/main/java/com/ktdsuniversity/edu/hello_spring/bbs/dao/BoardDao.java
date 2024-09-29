package com.ktdsuniversity.edu.hello_spring.bbs.dao;

import java.util.List;

import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.WriteBoardVO;

public interface BoardDao {

	public int selectBoardAllCount();
	
	public List<BoardVO> selectAllBoard();
	
	public int insertNewBoard(WriteBoardVO writeBoardVO); // insert한 개수를 반환시키기 위해서 int 사용.
	
	/**
	 * 게시글 ID의 조회수를 1 증가시킨다.
	 * @param id
	 * @return
	 */
	public int increaseViewCount(int id);
	
	/**
	 * 게시글 ID의 게시글 정보를 조회한다.
	 * @param id
	 * @return
	 */
	public BoardVO getOneBaord(int id);
}
