package com.ktdsuniversity.edu.hello_spring.member.dao;

import com.ktdsuniversity.edu.hello_spring.member.vo.LoginMemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.RegistMemberVO;

public interface MemberDao {

	/**
	 * 매번 복사 붙여넣기 번거로우니 상수로 만들어서 호출하게 만듬.
	 * 인터페이스에 변수를 만들면 상수가 된다. => static final 생략 가능.
	 */
	public String NAMESPACE ="com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao";
	
	public int selectCheckEmail(String email);
	
	public int insertRegistMember(RegistMemberVO registMemberVO);
	
	/**
	 * 이메일을 줄테니 salt를 가져와달라.
	 * @param email
	 * @return
	 */
	public String selectSalt(String email);
	
	public MemberVO selectOneMember(LoginMemberVO loginMemberVO);
	
	public int updateLoginFailState(LoginMemberVO loginMemberVO);
	
	public int selectLoginImpossibleCount(String email);
	
	public int updateLoginSuccessState(LoginMemberVO loginMemberVO);
	
	public int deleteMe(String email);
	
}
