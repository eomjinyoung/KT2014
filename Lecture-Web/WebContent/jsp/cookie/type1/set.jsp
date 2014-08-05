<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	request.setCharacterEncoding("euc-kr");
	String cName = request.getParameter("cName");
	String cValue = request.getParameter("cValue");
	
	// 쿠키생성
	Cookie c = new Cookie(cName, cValue);
	
	// 쿠키 클라이언트에 전송
	response.addCookie(c);
%>

<h1>쿠키 설정 완료</h1>
<a href="get.jsp">설정된 쿠키 확인</a>