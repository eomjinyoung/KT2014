<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*" %>
<html>
<head><title>���Ͽ��� �Ѿ�� ���� ���</title></head>
<body>
�Ѿ�� ���� ���<br />	
<% 
	InputStreamReader isr = 
		new InputStreamReader(
				request.getInputStream(),"EUC-KR");
	BufferedReader br = new BufferedReader(isr);
	String line = null;
	while((line=br.readLine()) != null){
		out.println(line+"<br />");
	}
%>
</body>
</html>