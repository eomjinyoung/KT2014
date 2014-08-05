<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="kr.co.kt.board.db.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
// 规过1
// 	List boardList = new ArrayList();
//	BoardVO board = new BoardVO();
//	board.setTitle("己傍");
//	boardList.add(board);

// 规过2
//	BoardVO board = new BoardVO();
//	board.setTitle("己傍");
//	BoardVO[] boardList = {board};

// 规过3
//	List boardList = new ArrayList();
//	Map board = new HashMap();
//	board.put("title", "己傍");
//	boardList.add(board);

// 规过4
	Map board = new HashMap();
	board.put("title", "己傍");
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
	<!-- 拳搁俊 己傍 免仿 -->
	boardList[0].title : ${ boardList[0].title } <br/>
</body>
</html>