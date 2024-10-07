package com.ktdsuniversity.edu.hello_spring.member.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao;
import com.ktdsuniversity.edu.hello_spring.member.vo.RegistMemberVO;

@Repository
public class MemberDaoImpl extends SqlSessionDaoSupport implements MemberDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	// email 검사
	@Override
	public int selectCheckEmail(String email) {
		return this.getSqlSession().selectOne("com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao.selectCheckEmail",email);
	}
	// 회원가입 절차.
	@Override
	public int insertRegistMember(RegistMemberVO registMemberVO) {
		return this.getSqlSession().insert("com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao.insertRegistMember",registMemberVO);
	}
	
	
}
