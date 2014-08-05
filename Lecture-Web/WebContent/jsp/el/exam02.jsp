<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	String[] hobbys = request.getParameterValues("hobby");
	if(hobbys == null) {
		hobbys = new String[]{"파라미터 없음"};
	}
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	request.getParameter("id") ?? <%= request.getParameter("id") %> <br/>
	id ?? ${ param.id } </br>
	request.getParameter("name") ?? <%= request.getParameter("name") %> <br/>
	name ?? ${ param.name } <br/>
	hobbys[0] : <%= hobbys[0] %> <br/>
	el hobby[0] : ${ paramValues.hobby[1] } <br/>

</body>
</html>






