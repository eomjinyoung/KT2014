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
<table border="1" width="100%">
	<tr>
		<td rowspan="2" style="width: 204px; height: 33px;">
			<a href="/Mission-Web">
				<img src="/Mission-Web/images/bit_logo.gif" style="border: 0px;"/>
			</a>
		</td>
		<td align="right">
			<a href="javascript:window.external.AddFavorite(
				'http://localhost:8000/Mission-Web', 'ù��°������')">
				���ã��
			</a>
			<c:if test="${ not empty userVO }" >
				${ userVO.id }������ �α��� ���Դϴ�.
			</c:if>
		</td>
	</tr>
	<tr>
		<td>
			<c:if test="${ userVO.type eq 'S' }">
			ȸ������ ||
			</c:if>
			<a href="/Mission-Web/jsp/board/list.jsp">�Խ���</a> ||
			<c:choose>
				<c:when test="${empty userVO}">
					ȸ������ ||
					<a href="/Mission-Web/jsp/login/login.jsp">�α���</a> ||
				</c:when>
				<c:otherwise>
					���������� ||
					<a href="/Mission-Web/jsp/login/logout.jsp">�α׾ƿ�</a>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
</table>
</body>
</html>





