<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	5+5 : <%= 5+5 %> <br/>
	el 5+5 : ${ 5+5 } <br/>
	9 % 5 : ${ 9 % 5 } <br/>
	9 mod 5 : ${ 9 mod 5 } <br/>	
	5 == 5 : ${ 5 == 5 } <br/>
	5 == 5 : ${ 5 eq 5 } <br/>
	5 != 5 : ${ 5 != 5 } <br/>
	5 != 5 : ${ 5 ne 5 } <br/>
	(5 == 5) && (5 < 3) : ${ (5 == 5) && (5 < 3) } <br/>
	(5 == 5) && (5 < 3) : ${ (5 == 5) and (5 < 3) } <br/>
	empty str : ${ empty str } <br/>
	not empty str : ${ not empty str } <br/>
	(5 % 2 == 0) ? "¦��" : "Ȧ��" �� �����??
		${ 5 % 2 == 0 ? "¦��" : "Ȧ��" } <br/> 
</body>
</html>











