<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	//인증된 세션이 없는 경우 => 해당 페이지를 볼 수 없게 한다.
	if(session.getAttribute("signedUser") == null) {
		response.sendRedirect("logout.jsp");
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome.jsp 환영 페이지</title>
</head>
<body>
	<h1><%= session.getAttribute("signedUser") %>님 <small>환영합니다.</small></h1>
</body>
</html>





