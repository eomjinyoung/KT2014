<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
//	String[] names = {"홍길동", "안길동", "나길동", "최길동"};

	List names = new ArrayList();
	names.add("홍길동");
	names.add("안길동");
	names.add("나길동");
	names.add("최길동");

	pageContext.setAttribute("names", names);
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	names[0] : <%= names.get(0) %> <br/>
	names[0] : ${ names[0] } <br/>
	names[1] : ${ names[1] } <br/>
	names[2] : ${ names[2] } <br/>
	names[3] : ${ names[3] } <br/>
</body>
</html>