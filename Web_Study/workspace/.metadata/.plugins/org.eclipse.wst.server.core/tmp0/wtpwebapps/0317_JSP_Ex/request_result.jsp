<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 폼에서 넘어오는 한글 데이터가 깨지지 않게하기 위해서 추가 -->  
<% request.setCharacterEncoding("UTF-8"); %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
	<h2>request 테스트 결과-1</h2>
	<hr>
	<table border="1" cellspacing="1" cellpadding="5">
		<tr>
			<td bgcolor="lime">이름</td>
			<td width="100"><%= request.getParameter("username") %></td>
		</tr>
		<tr>
			<td bgcolor="lime">직업</td>
			<td width="100"><%= request.getParameter("job") %></td>
		</tr>
		<tr>
			<td bgcolor="lime">관심분야</td>
			<td>
				<%	//자바 코드 기술
					String[] favorites = request.getParameterValues("favorite");
					for(int i=0; i<favorites.length; i++) {
						out.println(favorites[i] + "<br>");
					}
				%>
			</td>
		</tr>
	</table>
	<hr>
	<h2>request 테스트 결과 - 2</h2>
	<table border="0">
		<tr>
			<td>
				1. 클라이언트 IP 주소: <%= request.getRemoteAddr() %><br>
				2. 요청 메소드 : <%= request.getMethod() %><br>
				3. 요청 프로토콜 : <%= request.getProtocol() %>
			</td>
		</tr>
	</table>
	</center>
</body>
</html>



