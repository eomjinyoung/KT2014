<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	String id = (String)session.getAttribute("id");
	String password = (String)session.getAttribute("password");
%>    

<h1>������ ���� ����</h1>
<h2>������ ���� ���̵� : <%= id %></h2>
<h2>������ ���� �н����� : <%= password %></h2>
<h2>������ ���� ���̵� : ${ id }</h2>
<h2>������ ���� �н����� : ${ password }</h2>
<a href="remove.jsp">������ ���� ����</a>










