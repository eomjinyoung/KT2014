<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	Map b = new HashMap();
	
	b.put("no", 1);
	b.put("title", "���� �̿��� EL �׽�Ʈ");
	
	pageContext.setAttribute("board", b);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	1�ܰ� <br/>
	board.no : <%= b.get("no") %> <br/>
	board.title : <%= b.get("title") %> <br/><br/>
	
	2�ܰ� : <br/>
	board.no : <%= ((Map)pageContext.getAttribute("board")).get("no") %> <br/>
	board.title :
		<%= ((Map)pageContext.getAttribute("board")).get("title") %> <br/><br/>  
	
	
	3�ܰ� : el <br/>
	board.no : ${ board.no } <br/> 		<!-- get("no") ȣ�� -->
	board.title : ${ board.title } <br/><!-- get("title") ȣ�� -->
	
	board.aaa : ${ board.aaa } <br/>
</body>
</html>












