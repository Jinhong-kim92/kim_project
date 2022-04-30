<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sessionTestForm.jsp 페이지  => 클라이언트 측 </title>
</head>
<body>
	<h2>로그인 폼</h2>
	<form name="loginForm" method="POST" action="sessionTestPro.jsp">
		아이디: <input type="text" name="id"/><br>
		패스워드: <input type="password" name="passwd"/><br>
		<input type="submit" value="로그인"/>
	</form>
</body>
</html>





