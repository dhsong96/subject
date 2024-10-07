package com.ktdsuniversity.edu.hello_spring.bbs.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.ModifyBoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.WriteBoardVO;
//기능 정의
@Repository
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		System.out.println("Autowiring sqlSessionTemplate : " + sqlSessionTemplate);
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int selectBoardAllCount() {
		// getSqlSession을 이용해서 한개의 결과만 조회. 다소 길더라도 안전하게 호출 할 수 있다.중복방지
		return this.getSqlSession().selectOne("com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao.selectBoardAllCount"); 
	}

	@Override
	public List<BoardVO> selectAllBoard() {
		return this.getSqlSession().selectList("com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao.selectAllBoard");
	}

	@Override
	public int insertNewBoard(WriteBoardVO writeBoardVO) {
		return this.getSqlSession().insert("com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao.insertNewBoard", writeBoardVO);
	}
	
	@Override
	public int updateViewCount(int id) {
		return this.getSqlSession().insert("com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao.updateViewCount", id);
	}
	@Override
	public BoardVO selectOneBoard(int id) {
		return this.getSqlSession().selectOne("com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao.selectOneBoard", id);
	}
	
	@Override
	public int updateOneBoard(ModifyBoardVO modifyBoardVO) {
		return this.getSqlSession().update("com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao.updateOneBoard", modifyBoardVO);
	}
	
	@Override
	public int deleteOneBoard(int id) {
		return this.getSqlSession().delete("com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao.deleteOneBoard", id);
	}
}
