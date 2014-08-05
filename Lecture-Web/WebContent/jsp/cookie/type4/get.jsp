<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	StringBuilder sb = new StringBuilder();
	Cookie[] cookies = request.getCookies();
	
	if(cookies != null) {
		
		for(Cookie c : cookies) {
			String name = c.getName();
			       name = URLDecoder.decode(name, "euc-kr");
			String value = c.getValue();
			       value = URLDecoder.decode(value, "euc-kr");
			sb.append("쿠키이름 : " + name + ", ");
			sb.append("쿠키값 : " + value + "<br/>");
		}
		
	} else {
		sb.append("설정된 쿠키 정보가 없습니다. <br/>");
	}
%>    

<h1>설정된 쿠키 정보</h1>
<h2><%= sb.toString() %></h2>
<a href="remove.jsp">쿠키삭제</a>












