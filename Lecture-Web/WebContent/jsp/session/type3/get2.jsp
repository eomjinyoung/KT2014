<%@page import="kr.co.kt.member.db.MemberVO"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	MemberVO member = (MemberVO)session.getAttribute("member");

	if( member != null) {
%>    

<h1>설정된 세션 정보</h1>
<h2>설정된 세션 아이디 : <%= member.getId() %></h2>
<h2>설정된 세션 패스워드 : <%= member.getPassword() %></h2>
<%
	} else {
%>
<h2>설정된 세션이 없습니다.</h2>
<%
	}
%>
<a href="remove.jsp">설정된 세션 삭제</a>










