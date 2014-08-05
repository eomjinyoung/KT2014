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
	1을 가지는 변수 cnt를 공유영역(page)에 설정 <br/>
	<c:set var="cnt" value="1" />
	page영역의 변수 cnt값을 출력 <br/>
	${ cnt } <br/>
	page가 가지고 있는 변수 cnt값을 1 증가 변수 cnt를 request영역에 등록<br/>
	<c:set var="cnt" value="${ cnt+1 }" scope="request" />
	page : ${ cnt } <br/>
	request : ${ requestScope.cnt } <br/>
	
	request영역에 cnt변수 삭제 <br/>
	<%-- <c:remove var="cnt" /> --%>
	<c:remove var="cnt" scope="request" />
	
	page : ${cnt} <br/>
	request : ${ requestScope.cnt }<br/>
</body>
</html>














