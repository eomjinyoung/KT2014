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
	value �Ӽ��� ���� : <c:out value="JSTL" /> <br/>
	value �Ӽ��� ���� : <c:out value="${ msg }"/> <br/>
	value �Ӽ��� ������ ���� ã�� ���� ��� : 
			<c:out value="${ msg }" default="������" /> <br/>
	���� �±װ� ���Ե� ��� : <c:out value="<hr />" /> <br/>			
	���� �±װ� ���Ե� ��� escapteXML�� false�� ���� : 
			<c:out value="<hr />" escapeXml="false" /> <br/>	
	���� : <c:out value="<a href=&#034;http://www.naver.com&#034;>�׽�Ʈ</a>" />		
</body>
</html>