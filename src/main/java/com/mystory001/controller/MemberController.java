package com.mystory001.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mystory001.domain.MemberDTO;
import com.mystory001.service.MemberService;

@Controller
public class MemberController {
	
	//MemberService 객체생성 → 멤버변수
	//@Inject - MemberService 클래스 찾기 - @Service 애노테이션 자동 찾기 - 자동으로 객체 생성
	//servlet-context에 conponent-scan 추가
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {
		System.out.println("MemberController insert()");
		
		return "/member/insert"; //주소 변경없이 이동
	}

	@RequestMapping(value = "/member/insert", method = RequestMethod.POST)
	public String insertPro(MemberDTO memberDTO) {
		System.out.println("MemberController insertPro()");
		
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPw());
		System.out.println(memberDTO.getName());
		
		//회원가입 처리
		memberService.insertMember(memberDTO);
		
		return "redirect:/member/login";
	}
	
	
}
