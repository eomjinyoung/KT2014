<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1" width="100%">
	<tr>
		<td rowspan="2" style="width: 204px; height: 33px;">
			<a href="index.jsp">
				<img src="images/bit_logo.gif" style="border: 0px;"/>
			</a>
		</td>
		<td align="right">
			<a href="javascript:window.external.AddFavorite(
				'http://localhost:9999/mvc01', 'ù��°������')">
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
			<a href="jsp/board/list.jsp">�Խ���</a> ||
			<c:choose>
				<c:when test="${empty userVO}">
					ȸ������ ||
					<a href="jsp/login/login.jsp">�α���</a> ||
				</c:when>
				<c:otherwise>
					���������� ||
					<a href="jsp/login/logout.jsp">�α׾ƿ�</a>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
</table>






