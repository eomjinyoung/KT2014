<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	request.setCharacterEncoding("euc-kr");

	// 인코딩 방식
	String cName = request.getParameter("cName");
 	       cName = URLEncoder.encode(cName, "euc-kr");
 	String cValue = request.getParameter("cValue");
 		   cValue = URLEncoder.encode(cValue, "euc-kr");
	
	// 쿠키생성
	Cookie c = new Cookie(cName, cValue);
	
	// 쿠키 클라이언트에 전송
	response.addCookie(c);
%>

<h1>쿠키 설정 완료</h1>
<a href="get.jsp">설정된 쿠키 확인</a>