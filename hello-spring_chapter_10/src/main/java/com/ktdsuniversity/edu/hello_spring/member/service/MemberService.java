package com.ktdsuniversity.edu.hello_spring.member.service;

import com.ktdsuniversity.edu.hello_spring.member.vo.RegistMemberVO;

public interface MemberService {

	
	
	public boolean insertNewRegist(RegistMemberVO registMemberVO);
	
	public boolean checkAvailableEmail(String email);
	
	
	
}
