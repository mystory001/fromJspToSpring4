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
<title>info</title>
</head>
<body>
<h1>회원 정보 조회</h1>
<c:choose>
<c:when test="${!empty memberDTO }">
아이디 : ${memberDTO.id}<br>
비밀번호 : ${memberDTO.pw}<br>
이름 : ${memberDTO.name}<br>
가입날짜 : ${memberDTO.date}<br>
</c:when>
<c:otherwise>
아이디 없음
</c:otherwise>
</c:choose>
<a href="main.me">main.me 이동</a>
</body>
</html>