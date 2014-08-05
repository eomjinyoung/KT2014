<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	Map b = new HashMap();
	
	b.put("no", 1);
	b.put("title", "맵을 이용한 EL 테스트");
	
	pageContext.setAttribute("board", b);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	1단계 <br/>
	board.no : <%= b.get("no") %> <br/>
	board.title : <%= b.get("title") %> <br/><br/>
	
	2단계 : <br/>
	board.no : <%= ((Map)pageContext.getAttribute("board")).get("no") %> <br/>
	board.title :
		<%= ((Map)pageContext.getAttribute("board")).get("title") %> <br/><br/>  
	
	
	3단계 : el <br/>
	board.no : ${ board.no } <br/> 		<!-- get("no") 호출 -->
	board.title : ${ board.title } <br/><!-- get("title") 호출 -->
	
	board.aaa : ${ board.aaa } <br/>
</body>
</html>












