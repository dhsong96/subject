package com.ktdsuniversity.edu.hello_spring.bbs.dao.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.Import;

import com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.WriteBoardVO;

@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(BoardDaoImpl.class)
public class BoardDaoImplTest {

	@Autowired
	private BoardDao boardDao;
	
	
	
	@Test
	public void testInsertNewBoard() {
		WriteBoardVO wb = new WriteBoardVO();
		int count = this.boardDao.insertNewBoard(wb);
		wb.setContent("Test Content");
		wb.setEmail("Test Email");
		wb.setSubject("Test Subject");
		System.out.println("boardCount : " + count);
		
		int insertCount = this.boardDao.insertNewBoard(wb);
		assertTrue(insertCount == 1);
	}
}
