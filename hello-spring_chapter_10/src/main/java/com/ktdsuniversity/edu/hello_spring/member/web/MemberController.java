package com.ktdsuniversity.edu.hello_spring.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ktdsuniversity.edu.hello_spring.member.service.MemberService;
import com.ktdsuniversity.edu.hello_spring.member.vo.RegistMemberVO;

import jakarta.validation.Valid;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member/regist")
	public String viewRegistMemberPage() {
		return "member/memberlogin";
	}
	
	@PostMapping("/member/regist")
	public String doCreateNewMember(@Valid RegistMemberVO registMemberVO
			                       , BindingResult bindingResult
			                       , Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("registMemberVO",registMemberVO);
			return "member/memberlogin";
		}
		if(!registMemberVO.getPassword().equals(registMemberVO.getCheckPassword())) {
			model.addAttribute("passwordError", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("registMemberVO", registMemberVO);
			return "member/memberlogin";
		}
		this.memberService.insertNewRegist(registMemberVO);
		return "redirect:/board/list";
	}
}
