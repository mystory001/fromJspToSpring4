<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
<h1>메인</h1>
<%
String id = (String)session.getAttribute("id");
%>
<c:if test="${empty sessionScope.id }">
	<c:redirect url="/member/login" />
</c:if>

<%=id %> == ${sessionScope.id }님 환영합니다.<br>

<a href="${pageContext.request.contextPath }/member/info">정보 조회</a><br>
<a href="${pageContext.request.contextPath }/member/update">정보 수정</a><br>
<a href="${pageContext.request.contextPath }/member/delete">정보 삭제</a><br>
<a href="${pageContext.request.contextPath }/member/logout">로그아웃</a><br>
<c:if test="${! empty sessionScope.id }">
	<c:if test="${sessionScope.id =='admin' }">
		<a href="${pageContext.request.contextPath }/member/list">목록 조회</a><br>
	</c:if>
</c:if><br>
</body>
</html>