<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//인증 가능 사용자 ID와 패스워드 목록
	String[] userID = {"park","kim","hong"};
	String[] passwords = {"park1234","kim777","hong4567"};
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	int i;
	
	for(i=0; i<userID.length; i++){
		if(userID[i].equals(id) && passwords[i].equals(pw)){
			//인증 성공 시 => 세션 값 등록하기
			session.setAttribute("signedUser", id);
			response.sendRedirect("welcome.jsp");
		}
	}
	if(i == userID.length){
		out.println("<script>alert('입력한 아이디는 없는 아이디입니다.'); history.go(-1);</script>");
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>authentication.jsp 인증 페이지</title>
</head>
<body>

</body>
</html>