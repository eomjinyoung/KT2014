<%@page import="kr.co.kt.member.db.MemberVO"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	MemberVO member = (MemberVO)session.getAttribute("member");

	if( member != null) {
%>    

<h1>������ ���� ����</h1>
<h2>������ ���� ���̵� : <%= member.getId() %></h2>
<h2>������ ���� �н����� : <%= member.getPassword() %></h2>
<%
	} else {
%>
<h2>������ ������ �����ϴ�.</h2>
<%
	}
%>
<a href="remove.jsp">������ ���� ����</a>










