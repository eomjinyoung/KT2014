<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	request.setCharacterEncoding("euc-kr");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	session.setAttribute("id", id);
	session.setAttribute("password", password);
%>

<h1>���� ���� �Ϸ�</h1>
<a href="get.jsp">������ ����Ȯ��</a>