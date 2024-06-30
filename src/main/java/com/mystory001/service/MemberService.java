package com.mystory001.service;

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
		
		memberDAO.insertMember(memberDTO);
	}

}
