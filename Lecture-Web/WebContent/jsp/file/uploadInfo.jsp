<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*" %>
<html>
<head><title>파일에서 넘어온 정보 출력</title></head>
<body>
넘어온 정보 출력<br />	
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