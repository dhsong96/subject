package com.ktdsuniversity.edu.hello_spring.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao;
import com.ktdsuniversity.edu.hello_spring.member.service.MemberService;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.RegistMemberVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public boolean insertNewRegist(RegistMemberVO registMemberVO) {
		int emailCount = this.memberDao.selectCheckEmail(registMemberVO.getEmail());
		if (emailCount > 0) {
			throw new IllegalArgumentException("사용중인 이메일 입니다.");
		}
		int success = this.memberDao.insertRegistMember(registMemberVO);
		return success > 0;
	}
	
	@Override
	public boolean checkAvailableEmail(String email) {
		return this.memberDao.selectCheckEmail(email) > 0;
	}
	
	
	

}
