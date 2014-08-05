<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	StringBuilder sb = new StringBuilder();
	Cookie[] cookies = request.getCookies();
	
	if(cookies != null) {
		
		for(Cookie c : cookies) {
			String name = c.getName();
			String value = c.getValue();
			sb.append("��Ű�̸� : " + name + ", ");
			sb.append("��Ű�� : " + value + "<br/>");
		}
		
	} else {
		sb.append("������ ��Ű ������ �����ϴ�. <br/>");
	}
%>    

<h1>������ ��Ű ����</h1>
<h2><%= sb.toString() %></h2>
<a href="mainForm.jsp">��Ű ���� �̵�</a>











