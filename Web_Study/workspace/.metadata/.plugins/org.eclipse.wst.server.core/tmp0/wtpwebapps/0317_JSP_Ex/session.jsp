<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session.jsp 페이지</title>
</head>
<body>
	<h2>session 내장 객체 실습 예제</h2>
	<hr>
	<%	//스크립트릿 => 자바코드 기술
		if(session.isNew()) {
			out.println("<script> alert('세션이 해제되어 다시 설정합니다.')</script>");
			session.setAttribute("login", "홍길동");
		}
	%>
	1. 세션 ID : <%= session.getId() %><br>
	2. 세션 유지시간 : <%= session.getMaxInactiveInterval() %><br>
	3. login 세션의 설정값 : <%= session.getAttribute("login") %>
</body>
</html>



