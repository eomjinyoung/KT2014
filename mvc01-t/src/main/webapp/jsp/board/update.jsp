<%@page import="kr.co.kt.board.db.BoardVO"%>
<%@page import="kr.co.kt.board.db.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
request.setCharacterEncoding("euc-kr");

int no = Integer.parseInt(request.getParameter("no"));
String title = request.getParameter("title");
String content = request.getParameter("content");

BoardVO board = new BoardVO();
board.setNo(no);
board.setTitle(title);
board.setContent(content);

BoardDAO dao = new BoardDAO();
dao.update(board);
%>

<script>
	alert('�Խù�  ${param.no} �� �����Ǿ����ϴ�.');
	location.href = "detail.jsp?no=${param.no}";
</script>









