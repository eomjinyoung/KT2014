<%@page import="kr.co.kt.member.db.MemberVO"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	MemberVO member = (MemberVO)session.getAttribute("member");
%>    

<h1>������ ���� ����</h1>
<h2>������ ���� ���̵� : ${member.id} </h2>
<h2>������ ���� �н����� : ${member.password}</h2>
<a href="remove.jsp">������ ���� ����</a>










