<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	fn:length("hello jstl") : ${ fn:length("hello jstl") } <br/>
	fn:substring("hello jstl", 2, 4) : ${ fn:substring("hello jstl", 2, 4) } <br/>
	fn:substring("hello jstl", 2, -1) : ${ fn:substring("hello jstl", 2, -1) } <br/>
	
	<c:set var="msg" value="hello jstl" />
	fn:length(msg) : ${ fn:length(msg) } <br/>
</body>
</html>