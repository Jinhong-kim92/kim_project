<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- �߰� --> 
<%@ page import="com.company.mvc_fw_board.board.BoardDO" %>
<%@ page import="java.util.List" %>

<% List<BoardDO> boardList = (List)session.getAttribute("boardList"); %> 

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% 
	int totalList = boardList.size();
	request.setAttribute("totalList", totalList);
%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ü �Խñ� ��� ���� ������ => getBoardList.jsp</title>
<style>
	#div_box {
		position:absolute;
		top:10%;
		left:20%;
	}
</style>
</head>
<body>
	<div id="div_box">
		<h3>${IdKey}�� ȯ���մϴ�.&nbsp;&nbsp;&nbsp;<a href="logout.do">�α׾ƿ�</a></h3>
		<form name="getBoardListForm" method="POST" action="getBoardList.do">
			<p>�� �Խñ�: ${totalList}��</p>
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right">
						<select name="searchCondition">
							<option value="TITLE">����
							<option value="WRITER">�ۼ���
						</select>
						<input type="text" name="searchKeyword"/>
						<input type="submit" value="�˻�"/>
					</td>
				</tr>				
			</table>
		</form>
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">��ȣ</th>
				<th bgcolor="orange" width="200">����</th>
				<th bgcolor="orange" width="150">�ۼ���</th>
				<th bgcolor="orange" width="150">�ۼ�����</th>
				<th bgcolor="orange" width="100">��ȸ��</th>
			</tr>
			<c:forEach var="board" items="${boardList}">
				<tr>
					<td align="center">${board.seq}</td>
					<td align="left"><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
					<td align="center">${board.writer}</td>
					<td align="center">${board.regdate}</td>
					<td align="center">${board.cnt}</td>
				</tr>
			</c:forEach>
		</table>
		<br><br>
		<a href="insertBoard.jsp">�� �Խñ� ���</a>
		<a href="getBoardList.do">��ü �Խñ� ��� ����</a>
	</div>
</body>
</html>




