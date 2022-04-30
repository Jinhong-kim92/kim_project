<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sessionTestPro.jsp 페이지 => 서버 측</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
	    String passwd = request.getParameter("passwd");
	    
	    session.setAttribute("id", id);
	    session.setAttribute("passwd", passwd);	    
	%>
	id와 passwd 세션 속성을 설정하였습니다!<br>
	id 속성의 속성값은 <%= (String)session.getAttribute("id") %> 이고<br>
	passwd 속성의 속성값은 <%= (String)session.getAttribute("passwd") %> 입니다.
</body>
</html>



