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
	<h2>�����ȸ</h2>
	
	<table>
		<tr>
			<th>����</th>
			<th>�۾���</th>
		</tr>
		<c:forEach var="board" items="${ list }">
		<tr>
			<td><c:out value="${ board.title }" /></td>
			<td><c:out value="${ board.writer }"/></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>











