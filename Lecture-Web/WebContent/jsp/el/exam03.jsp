<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	// pageContext, request, session, application
	pageContext.setAttribute("msg", "page 영역에 등록");

	// request 영역에 'id' 이름으로, 값은"ssss"으로 등록
	request.setAttribute("id", "ssss");
	
	request.setAttribute("msg", "request 영역에 등록");
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	empty msg : ${ empty msg } <br/>
	msg : ${ msg } <br/>
	request msg : ${ requestScope.msg }<br/>
	request msg : <%= request.getAttribute("msg") %> <br/>
	id : ${ id } <br/>
</body>
</html>






