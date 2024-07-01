package com.mystory001.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mystory001.domain.MemberDTO;
import com.mystory001.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	//MemberService 객체생성 → 멤버변수
	//@Inject - MemberService 클래스 찾기 - @Service 애노테이션 자동 찾기 - 자동으로 객체 생성
	//servlet-context에 conponent-scan 추가
	@Inject
	private MemberService memberService;
	
	//@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	@GetMapping("insert") //@RequestMapping("/member/*") 애노테이션 추가로 위의 코드보다 짧고 간결하게 사용할 수 있음
	public String insert() {
		System.out.println("MemberController insert()");
		
		return "/member/insert"; //주소 변경없이 이동
	}

	//@RequestMapping(value = "/member/insert", method = RequestMethod.POST)
	@PostMapping("/insertPro")
	public String insertPro(MemberDTO memberDTO) {
		System.out.println("MemberController insertPro()");
		System.out.println(memberDTO.toString());
		
		//회원가입 처리
		memberService.insertMember(memberDTO);
		
		return "redirect:/member/login";
	}
	
	@GetMapping("/login")
	public String login(){
		System.out.println("MemberController login()");
		
		return "member/login";
	}
	
	@PostMapping("/loginPro")
	public String loginPro(MemberDTO memberDTO) {
		System.out.println("MemberController loginPro()");
		
		//로그인 처리
		if((memberService.userCheck(memberDTO)) !=null) {
			return "redirect:/member/main";
		} 
		return "redirect:/member/login";
		
	}
	
	
}
