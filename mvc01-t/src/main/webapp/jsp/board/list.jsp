<%@page import="kr.co.kt.board.db.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.kt.board.db.BoardDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- <%@ page import="java.sql.Connection, java.sql.PreparedStatement" %> --%> 
<%-- <%@ page import="java.sql.PreparedStatement" %> --%> 

<%--
		�Խù� ��� ��ȸ ����
		1. �����ͺ��̽��κ��� �Խù��� ��ȸ(t_board)
		2. ȭ�鿡 ��ȸ�� �Խù��� ���
 --%>  
 
<%
 	BoardDAO dao = new BoardDAO();
	List<BoardVO> list = dao.selectAll();
	
	pageContext.setAttribute("list", list);
%>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Խ��� ���</title>
<link rel="stylesheet" href="/Mission-Web/css/layout.css" />
<link rel="stylesheet" href="/Mission-Web/css/board.css" />
<script>
	function goWriteForm() {
		location.href = "writeForm.jsp";
	}
	
	function doAction(boardNo) {
		<c:choose>
			<c:when test="${not empty userVO}">
				location.href = "detail.jsp?type=list&no=" + boardNo;
			</c:when>
			<c:otherwise>
				if(confirm("�α��� �� ��밡���մϴ�.\n�α��� �������� �̵��Ͻðڽ��ϱ�?"))
					location.href = "/Mission-Web/jsp/login/login.jsp";
			</c:otherwise>
		</c:choose>
	}
	
</script>

</head>
<body>
	<div id="header">
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</div>
	<div id="content">
		<div align="center">
			<hr width="80%" />
			<h2>�Խ��� ���</h2>
			<hr width="80%" />
			<br />

			<table width="100%" class="list">
				<tr>
					<th width="7%">��ȣ</th>
					<th>����</th>
					<th width="16%">�۾���</th>
					<th width="20%">�����</th>
				</tr>

				<c:forEach var="board" items="${ list }" varStatus="loop">
					<tr <c:if test="${loop.count mod 2 == 0 }">class="even"</c:if>>
						<td>${ board.no }</td>
						<td>
							<a href="javascript:doAction('${board.no}')">
						 		<c:out	value="${ board.title }" />
						 	</a>
						 </td>
						<td>${ board.writer }</td>
						<td>${ board.regDate }</td>
					</tr>
				</c:forEach>
			</table>

			<br />
			<c:if test="${not empty userVO}" >
			<!-- <a href="writeForm.jsp">���۵��</a> -->
			<input type="button" value="���۵��" onclick="goWriteForm()" />
			</c:if>
		</div>
	</div>
	<div id="bottom">
		<%@ include file="/jsp/include/bottom.jsp"%>
	</div>

</body>
</html>

















