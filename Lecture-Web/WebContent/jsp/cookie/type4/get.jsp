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
			sb.append("��Ű�̸� : " + name + ", ");
			sb.append("��Ű�� : " + value + "<br/>");
		}
		
	} else {
		sb.append("������ ��Ű ������ �����ϴ�. <br/>");
	}
%>    

<h1>������ ��Ű ����</h1>
<h2><%= sb.toString() %></h2>
<a href="remove.jsp">��Ű����</a>












