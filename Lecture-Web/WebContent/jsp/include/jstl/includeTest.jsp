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
	<h1>인클루드 하기 전</h1>	
	<h1>파라미터 미설정 호출</h1>
	<c:import url="one.jsp" />
	<h1>인클루드 하기 후</h1>	
	<h1>파라미터 설정 호출</h1>
	<c:import url="one.jsp" >
		<c:param name="id" value="test" />
	</c:import>
	<h1>Daum 사이트 include 실습</h1>
	<c:import url="http://www.daum.net" />
</body>
</html>










