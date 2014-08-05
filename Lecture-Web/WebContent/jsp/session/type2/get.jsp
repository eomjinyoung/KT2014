<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	String id = (String)session.getAttribute("id");
	String password = (String)session.getAttribute("password");
%>    

<h1>설정된 세션 정보</h1>
<h2>설정된 세션 아이디 : <%= id %></h2>
<h2>설정된 세션 패스워드 : <%= password %></h2>
<h2>설정된 세션 아이디 : ${ id }</h2>
<h2>설정된 세션 패스워드 : ${ password }</h2>
<a href="remove.jsp">설정된 세션 삭제</a>










