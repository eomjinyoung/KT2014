<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String[] names = {"철수", "영희", "만수", "봉숙"};
	pageContext.setAttribute("names", names);
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="element" items="${ names }">
		${ element }
	</c:forEach>
	<br/>
	
	first:last:index:count순으로 출력 <br/>
	<c:forEach var="element" items="${ names }" varStatus="loop">
		${ loop.first }
		:${ loop.last }
		:${ loop.index }
		:${ loop.count } <br/>
	</c:forEach>
	<br/>
	
	<c:forEach var="i" begin="1"  end="10">
		${ i }
	</c:forEach>
	<br/>
	<br/>
	
	<select>
		<c:forEach var="year" begin="1960" end="2014">
			<option>${ year }</option>
		</c:forEach>
	</select>
</body>
</html>










