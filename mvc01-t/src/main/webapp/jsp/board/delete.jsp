<%@page import="kr.co.kt.board.db.BoardDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.co.kt.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
int no = Integer.parseInt(request.getParameter("no"));

BoardDAO dao = new BoardDAO();
dao.deleteFile(no);
dao.delete(no);

%>

<script>
	alert('�Խù� ��ȣ <%= no %> �� �����Ǿ����ϴ�.');
	location.href = "list.jsp";
</script>