package com.mystory001.service;

import java.sql.Timestamp;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mystory001.dao.MemberDAO;
import com.mystory001.domain.MemberDTO;

@Service
public class MemberService {
	
	//MemberDAO 객체생성 - 멤버변수
	//@Inject - MemberDAO 클래스 찾기 - @Repsitory 애노테이션 찾기 - 자동으로 객체 생성
	//servlet-context에 component-scan 추가
	@Inject
	private MemberDAO memberDAO;
	
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberService insertMember()"); 
		
		memberDTO.setDate(new Timestamp(System.currentTimeMillis())); //가입날짜 설정
		
		memberDAO.insertMember(memberDTO); //insertMember()메소드 호출
	}

	public MemberDTO userCheck(MemberDTO memberDTO) {
		System.out.println("MemberService userCheck()");
		
		//userCheck 메소드 호출
		return memberDAO.userCheck(memberDTO);
	}

}
