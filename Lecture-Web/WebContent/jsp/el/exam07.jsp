<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="kr.co.kt.board.db.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
// ���1
// 	List boardList = new ArrayList();
//	BoardVO board = new BoardVO();
//	board.setTitle("����");
//	boardList.add(board);

// ���2
//	BoardVO board = new BoardVO();
//	board.setTitle("����");
//	BoardVO[] boardList = {board};

// ���3
//	List boardList = new ArrayList();
//	Map board = new HashMap();
//	board.put("title", "����");
//	boardList.add(board);

// ���4
	Map board = new HashMap();
	board.put("title", "����");
	Map[] boardList = {board};
	
	pageContext.setAttribute("boardList", boardList);
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- ȭ�鿡 ���� ��� -->
	boardList[0].title : ${ boardList[0].title } <br/>
</body>
</html>