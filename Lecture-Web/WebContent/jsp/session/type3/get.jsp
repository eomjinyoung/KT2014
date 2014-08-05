<%@page import="kr.co.kt.member.db.MemberVO"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	MemberVO member = (MemberVO)session.getAttribute("member");
%>    

<h1>설정된 세션 정보</h1>
<h2>설정된 세션 아이디 : ${member.id} </h2>
<h2>설정된 세션 패스워드 : ${member.password}</h2>
<a href="remove.jsp">설정된 세션 삭제</a>










