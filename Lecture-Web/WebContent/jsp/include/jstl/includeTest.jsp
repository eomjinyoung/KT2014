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
	<h1>��Ŭ��� �ϱ� ��</h1>	
	<h1>�Ķ���� �̼��� ȣ��</h1>
	<c:import url="one.jsp" />
	<h1>��Ŭ��� �ϱ� ��</h1>	
	<h1>�Ķ���� ���� ȣ��</h1>
	<c:import url="one.jsp" >
		<c:param name="id" value="test" />
	</c:import>
	<h1>Daum ����Ʈ include �ǽ�</h1>
	<c:import url="http://www.daum.net" />
</body>
</html>










