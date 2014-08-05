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
<c:choose>
	<c:when test="${ param.id eq 'admin' }" >
		<jsp:forward page="admin.jsp"/>
	</c:when>
	<c:otherwise>
		<jsp:forward page="user.jsp">
			<jsp:param value="${ param.id }" name="id"/>
		</jsp:forward>
	</c:otherwise>
</c:choose>
</body>
</html>