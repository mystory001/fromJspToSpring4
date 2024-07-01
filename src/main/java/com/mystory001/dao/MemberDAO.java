package com.mystory001.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mystory001.domain.MemberDTO;
@Repository
public class MemberDAO {
	
	//마이바티스 멤버 변수 정의 → 객체 생성을 자동으로 전달(주입) 받음
	@Inject
	private SqlSession sqlSession;
	//com.mystory001.mapper.memberMapper를 변수로 치환해서 사용
	private static final String namespace = "com.mystory001.mappers.memberMapper";

//	public void insertMember(MemberDTO memberDTO) {
//		System.out.println("MemberDAO insertMember()");
//		
//		sqlSession.insert(namespace+"insertMember", memberDTO); //sql구문(전체파일이름.sql 구문이름, 값)
//	}
	
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberDAO insertMember()");
		
		sqlSession.insert(namespace+".insertMember", memberDTO);
		
	}
	
	public MemberDTO userCheck(MemberDTO memberDTO) {
		System.out.println("MemberDAO userCheck()");
		
		return sqlSession.selectOne(namespace+".userCheck", memberDTO);
		//selectOne() : 리턴 결과가 1개
		//selectList() : List형으로 리턴
		//selectMap() : Map형으로 리턴
	}


}
