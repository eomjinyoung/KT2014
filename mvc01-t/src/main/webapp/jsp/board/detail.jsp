<%@page import="kr.co.kt.board.db.BoardFileVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.kt.board.db.BoardVO"%>
<%@page import="kr.co.kt.board.db.BoardDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.kt.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%--
		1. no �Ķ���͸� ���´�.
		2. no�� �ش��ϴ� �����͸� ��ȸ�Ѵ�.(t_boar ���̺�)
		3. ��ȸ�� �����͸� ȭ�鿡 ����Ѵ�.
 --%>    
 
 <%
 int no = Integer.parseInt(request.getParameter("no"));
 
 BoardDAO dao = new BoardDAO();

 // list.jsp���� detail.jsp�� ȣ���� ��츸 ��ȸ�� �����ϵ��� ó�� type=list
 String type = request.getParameter("type");
 if(type != null && type.equals("list")) {
 	dao.updateViewCnt(no);	
 }
 
 // �Խñ� ���� ��ȸ
 BoardVO board = dao.selectByNo(no);
 
 // ÷������ ��� ��ȸ
 List<BoardFileVO> fileList = dao.selectFileBoard(no);
 
 pageContext.setAttribute("board", board);
 pageContext.setAttribute("fileList", fileList);
 %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��ȭ��</title>
<link rel="stylesheet" href="/Mission-Web/css/layout.css" />
<link rel="stylesheet" href="/Mission-Web/css/board.css" />
<script>
	function doAction(type) {
		switch(type) {
		case 'U' : 
			location.href = "updateForm.jsp?no=${param.no}";
			break;
		case 'D' :
			if(!confirm('�����Ͻðڽ��ϱ�')) {
				return false;
			}
			location.href = "delete.jsp?no=${param.no}";
			break;
		case 'L' :
			location.href = "list.jsp";
			break;
		}
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
	<h2>�Խ��� ��</h2>
	<hr width="80%" />
	<br/>
	
	<table width="80%" border="1">
		<tr>
			<th width="25%">��ȣ</th>
			<td>${ board.no }</td>
		</tr>
		<tr>
			<th width="25%">����</th>
			<td><c:out value="${ board.title }" /></td>
		</tr>
		<tr>
			<th width="25%">�۾���</th>
			<td>${ board.writer }</td>
		</tr>
		<tr>
			<th width="25%">����</th>
			<td>${ board.content }</td>
		</tr>
		<tr>
			<th width="25%">��ȸ��</th>
			<td>${ board.viewCnt }</td>
		</tr>
		<tr>
			<th width="25%">�����</th>
			<td>${ board.regDate }</td>
		</tr>
		<tr>
			<th>÷������</th>
			<td align="left">
				<c:forEach var="file" items="${ fileList }" >
					<a href="/Mission-Web/upload/${file.fileSaveName }"
						 target="blink" >
						<c:out value="${ file.fileOriName }" />
					</a>&nbsp;
					(${ file.fileSize }byte) <br/>
				</c:forEach>
			</td>
		</tr>
	</table>
	<br/>
	<input type="button" value="������" onclick="doAction('U')" />&nbsp;
	<input type="button" value=" ����  " onclick="doAction('D')" />&nbsp;
	<input type="button" value=" ���  " onclick="doAction('L')" />
</div>
	</div>
	<div id="bottom">
		<%@ include file="/jsp/include/bottom.jsp" %>
	</div>

</body>
</html>
























