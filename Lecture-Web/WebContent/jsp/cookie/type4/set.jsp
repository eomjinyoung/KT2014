<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	request.setCharacterEncoding("euc-kr");

//	String name = "type1";
//	String value = "/ 루트설정";
//	       value = URLEncoder.encode(value, "euc-kr");
//	Cookie c = new Cookie(name, value);
//	c.setPath("/"); 

	Cookie c = new Cookie("type1", 
			URLEncoder.encode("/ 루트설정", "euc-kr"));
	c.setPath("/");
	
	Cookie c2 = new Cookie("type2", 
			URLEncoder.encode("/Lecture-Web/jsp/cookie 루트 설정", "euc-kr"));
	c2.setPath("/Lecture-Web/jsp/cookie");
	
	Cookie c3 = new Cookie("type3", 
			URLEncoder.encode("/Lecture-Web/jsp/cookie/type3 루트 설정", "euc-kr"));
	c3.setPath("/Lecture-Web/jsp/cookie/type3");
	
	Cookie c4 = new Cookie("type4", 
			URLEncoder.encode("/Lecture-Web/jsp/cookie/type4 루트 설정", "euc-kr"));
	c4.setPath("/Lecture-Web/jsp/cookie/type4");
	
	response.addCookie(c);
	response.addCookie(c2);
	response.addCookie(c3);
	response.addCookie(c4);
%>

<h1>쿠키 설정 완료</h1>
<a href="get.jsp">설정된 쿠키 확인</a>










