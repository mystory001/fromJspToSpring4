<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러코드</title>
</head>
<body>
https://001cloudid.tistory.com/entry/240129-WEB

문제사항
1) 오류발생
Request processing failed; nested exception is org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.exceptions.PersistenceException

2) 확인 사항
변수 이름 확인 및 id 값 확인
설정 파일 확인
오타 확인

3) 문제 해결
-mappers-memberMapper.xml에서 문제가 있었음 → 오타 문제
·설정파일 복붙하는 과정에서 com.itwillbs.mappers.memberMappers로 되어 있었음
com.mystory001.mappers.memberMappers로 수정
·xml파일 이름과 다름 memberMappers로 되어 있어 s 삭제
</body>
</html>