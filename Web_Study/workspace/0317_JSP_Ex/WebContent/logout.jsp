<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 기존의 세션 데이터를 모두 삭제
	session.invalidate();

	//2. 로그인 페이지로 이동하라!!
	response.sendRedirect("loginForm.jsp");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logout.jsp 페이지</title>
</head>
<body>

</body>
</html>