package com.ktdsuniversity.edu.hello_spring.bbs.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.hello_spring.bbs.dao.impl.BoardDaoImpl;
import com.ktdsuniversity.edu.hello_spring.bbs.service.BoardService;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.WriteBoardVO;

@SpringBootTest
@Import( { BoardServiceImpl.class, BoardDaoImpl.class } )
public class BoardServiceImplTest {

	@Autowired
	private BoardService boardService;
	
	@MockBean
	private BoardDao boardDao;
	
	@Test
	public void testCreatNewBoard() {
		WriteBoardVO writeBoardVO = new WriteBoardVO();
		// given - when - then
		
		BDDMockito.given(boardDao.insertNewBoard(writeBoardVO)).willReturn(3);
		// 알고자 하는것이 boardService의 creatNewBoard.
		boolean creatNewBoard = boardService.creatNewBoard(writeBoardVO);
		assertEquals(true, creatNewBoard);
	}
}
