<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>인클루드 하기 전</h1>	
	<h1>파라미터 미설정 호출</h1>
	<jsp:include page="one.jsp" />
	<h1>인클루드 하기 후</h1>	
	<h1>파라미터 설정 호출</h1>
	<jsp:include page="one.jsp">
		<jsp:param name="id" value="test" />
	</jsp:include>
</body>
</html>