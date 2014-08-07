<%@page import="kr.co.kt.board.db.BoardVO"%>
<%@page import="kr.co.kt.board.db.BoardDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	int no = Integer.parseInt(request.getParameter("no"));
	BoardDAO dao = new BoardDAO();
	BoardVO board = dao.selectByNo(no);
	pageContext.setAttribute("board", board);
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="/Mission-Web/css/layout.css" />
<link rel="stylesheet" href="/Mission-Web/css/board.css" />

<script>
	function doAction() {
		location.href = "list.jsp";
	}
</script>
</head>
<body>
<div id="header" >
	<jsp:include page="/jsp/include/topMenu.jsp" />
</div>
<div id="content" align="center">
	<hr width="80%" />
	<h2>�Խù� ����</h2>
	<hr width="80%" />
	<br>
	
	<form action="update.jsp" method="post">
	<input type="hidden" name="no" value="${ param.no }" />
	<table width="80%">
		<tr>
			<th width="25%">��ȣ</th>
			<td>${ board.no }</td>
		</tr>
		<tr>
			<th>����</th>
			<td>
				<input type="text" name="title" size="50" value="<c:out value="${board.title }" />" />
			</td>
		</tr>
		<tr>
			<th>�۾���</th>
			<td>${ board.writer }</td>
		</tr>
		<tr>
			<th>����</th>
			<td>
				<textarea name="content" rows="7" cols="50">${board.content }</textarea>
			</td>
		</tr>
		<tr>
			<th>��ȸ��</th>
			<td>${ board.viewCnt }</td>
		</tr>
	</table>
		<br/>
		<input type="submit" value=" ���� " />&nbsp;
		<input type="button" value=" ��� " onclick="doAction()" />
	</form>
</div>
<div id="bottom">
	<%@ include file="/jsp/include/bottom.jsp" %>
</div>
</body>
</html>






