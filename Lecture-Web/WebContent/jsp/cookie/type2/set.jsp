<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	request.setCharacterEncoding("euc-kr");

	// ���ڵ� ���
	String cName = request.getParameter("cName");
 	       cName = URLEncoder.encode(cName, "euc-kr");
 	String cValue = request.getParameter("cValue");
 		   cValue = URLEncoder.encode(cValue, "euc-kr");
	
	// ��Ű����
	Cookie c = new Cookie(cName, cValue);
	
	// ��Ű Ŭ���̾�Ʈ�� ����
	response.addCookie(c);
%>

<h1>��Ű ���� �Ϸ�</h1>
<a href="get.jsp">������ ��Ű Ȯ��</a>