<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");

//	String name = "type1";
//	String value = "/ ��Ʈ����";
//	       value = URLEncoder.encode(value, "euc-kr");
//	Cookie c = new Cookie(name, value);
//	c.setPath("/"); 

	Cookie c = new Cookie("type1", 
			URLEncoder.encode("/ ��Ʈ����", "euc-kr"));
	c.setPath("/");
	c.setMaxAge(0); 
	
	Cookie c2 = new Cookie("type2", 
			URLEncoder.encode("/Lecture-Web/jsp/cookie ��Ʈ ����", "euc-kr"));
	c2.setPath("/Lecture-Web/jsp/cookie");
	c2.setMaxAge(0);
	
	Cookie c3 = new Cookie("type3", 
			URLEncoder.encode("/Lecture-Web/jsp/cookie/type3 ��Ʈ ����", "euc-kr"));
	c3.setPath("/Lecture-Web/jsp/cookie/type3");
	c3.setMaxAge(0);
	
	Cookie c4 = new Cookie("type4", 
			URLEncoder.encode("/Lecture-Web/jsp/cookie/type4 ��Ʈ ����", "euc-kr"));
	c4.setPath("/Lecture-Web/jsp/cookie/type4");
	c4.setMaxAge(0);

	
	response.addCookie(c);
	response.addCookie(c2);
	response.addCookie(c3);
	response.addCookie(c4);
	
	
%>

<h1>��Ű ���� �Ϸ�</h1>
<a href="get.jsp">������ ��Ű Ȯ��</a>












