<%@page import="kr.co.kt.board.db.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	// 1. �ڹٺ��� Ŭ���� ����
	BoardVO board = new BoardVO();
	board.setNo(1);
	board.setTitle("test");
	
	// 2. ���������� ���(pageContext����)
	//    �̸� : board, �� : ������ board ��ý
	pageContext.setAttribute("board", board);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	1�ܰ�<br/>
	board.no : <%= board.getNo() %> <br/>
	board.title : <%= board.getTitle() %> <br/><br/>
	
	2�ܰ� : <br/>
	board.no : <%= ((BoardVO)pageContext.getAttribute("board")).getNo() %> <br/>
	board.title : 
		<%= ((BoardVO)pageContext.getAttribute("board")).getTitle() %> <br/><br/>

	3�ܰ� : el��� 	<br/>
	board.no : ${ pageScope.board.no } <br/>  <!-- getNo() �޼ҵ� ȣ��  -->
	board.title : ${ board.title } <br/><br/> <!-- getTitle() �޼ҵ� ȣ�� -->
	
	board.aaa : ${ board.aaa } <br/>
	
</body>
</html>












