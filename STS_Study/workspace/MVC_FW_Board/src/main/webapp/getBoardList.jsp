<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 추가 --> 
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
<title>전체 게시글 목록 보기 페이지 => getBoardList.jsp</title>
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
		<h3>${IdKey}님 환영합니다.&nbsp;&nbsp;&nbsp;<a href="logout.do">로그아웃</a></h3>
		<form name="getBoardListForm" method="POST" action="getBoardList.do">
			<p>총 게시글: ${totalList}건</p>
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right">
						<select name="searchCondition">
							<option value="TITLE">제목
							<option value="WRITER">작성자
						</select>
						<input type="text" name="searchKeyword"/>
						<input type="submit" value="검색"/>
					</td>
				</tr>				
			</table>
		</form>
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">번호</th>
				<th bgcolor="orange" width="200">제목</th>
				<th bgcolor="orange" width="150">작성자</th>
				<th bgcolor="orange" width="150">작성일자</th>
				<th bgcolor="orange" width="100">조회수</th>
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
		<a href="insertBoard.jsp">새 게시글 등록</a>
		<a href="getBoardList.do">전체 게시글 목록 보기</a>
	</div>
</body>
</html>




