<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
</head>
<body>
<h1>회원 정보 수정</h1>
<c:if test="${!empty memberDTO }">
<form action="${pageContext.request.contextPath}/member/updatePro" method="post">
아이디 : <input type="text" name="id" value="${memberDTO.id }" readonly><br>
비밀번호 : <input type="password" name="pw"> 비밀번호 입력 시 회원정보 수정<br>
이름 : <input type="text" name="name" value="${memberDTO.name }"><br>
<input type="submit" value="수정하기">
</form>
</c:if>
<c:if test="${empty memberDTO }">
아이디 없음
</c:if>
</body>
</html>