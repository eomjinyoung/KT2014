<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	1�� ������ ���� cnt�� ��������(page)�� ���� <br/>
	<c:set var="cnt" value="1" />
	page������ ���� cnt���� ��� <br/>
	${ cnt } <br/>
	page�� ������ �ִ� ���� cnt���� 1 ���� ���� cnt�� request������ ���<br/>
	<c:set var="cnt" value="${ cnt+1 }" scope="request" />
	page : ${ cnt } <br/>
	request : ${ requestScope.cnt } <br/>
	
	request������ cnt���� ���� <br/>
	<%-- <c:remove var="cnt" /> --%>
	<c:remove var="cnt" scope="request" />
	
	page : ${cnt} <br/>
	request : ${ requestScope.cnt }<br/>
</body>
</html>














