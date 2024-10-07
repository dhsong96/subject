package com.ktdsuniversity.edu.hello_spring.member.dao;

import com.ktdsuniversity.edu.hello_spring.member.vo.RegistMemberVO;

public interface MemberDao {

	
	public int selectCheckEmail(String email);
	
	public int insertRegistMember(RegistMemberVO registMemberVO);
	
	
	
}
