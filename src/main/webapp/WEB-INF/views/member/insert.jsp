<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert</title>
</head>
<body>
<!-- 
가상 주소 http://localhost:8080/spring/member/insert 
실제페이지(화면) http://localhost:8080/spring/member/insert
<form action="insertPro" method="post">
현 위치 http://localhost:8080/spring/member/member/insertPro
절대위치 http://localhost:8080/프로젝트명/member/insertPro
-->

<h1>member/insert.jsp</h1>
<h2>회원가입</h2>
<%-- <form action="<%=request.getContextPath() %>/member/insertPro" method="post"> --%>
<form action="${pageContext.request.contextPath}/member/insertPro" method="post">
아이디 : <input type="text" name="id"><br>
비밀번호 : <input type="password" name="pw"><br>
이름 : <input type="text" name="name"><br>
<input type="submit" value="회원가입">
</form>
</body>
</html>