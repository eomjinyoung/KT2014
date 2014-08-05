<%@page import="kr.co.kt.board.db.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	// 1. 자바빈즈 클래스 생성
	BoardVO board = new BoardVO();
	board.setNo(1);
	board.setTitle("test");
	
	// 2. 공유영역에 등록(pageContext영역)
	//    이름 : board, 값 : 생성된 board 객첵
	pageContext.setAttribute("board", board);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	1단계<br/>
	board.no : <%= board.getNo() %> <br/>
	board.title : <%= board.getTitle() %> <br/><br/>
	
	2단계 : <br/>
	board.no : <%= ((BoardVO)pageContext.getAttribute("board")).getNo() %> <br/>
	board.title : 
		<%= ((BoardVO)pageContext.getAttribute("board")).getTitle() %> <br/><br/>

	3단계 : el사용 	<br/>
	board.no : ${ pageScope.board.no } <br/>  <!-- getNo() 메소드 호출  -->
	board.title : ${ board.title } <br/><br/> <!-- getTitle() 메소드 호출 -->
	
	board.aaa : ${ board.aaa } <br/>
	
</body>
</html>












