<%@page import="kr.co.kt.board.db.BoardFileVO"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="kr.co.kt.util.BitFileNamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="kr.co.kt.board.db.BoardVO"%>
<%@page import="kr.co.kt.board.db.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="kr.co.kt.util.ConnectionFactory" %>    
    
<%--
		1. ����ڰ� �Է��� �Ķ���͸� ���´�.
		2. ���� ������ DB(t_board ���̺�)�� �����Ѵ�.
		3. ����ڿ��� �޼����� ������ ���â���� �̵��Ѵ�.
 --%>    

<%
request.setCharacterEncoding("euc-kr");

String saveFolder = "D:\\Lecture\\Web_workspace\\Mission-Web\\WebContent\\upload";

MultipartRequest multi = new MultipartRequest(
		request
		, saveFolder			// ����� ���
		, 1024 * 1024 * 3 		// ���Ͽ� �ø� �ִ�ũ�� : 3MB
		, "euc-kr"				// ���ڵ� Ÿ��
		, new BitFileNamePolicy()
		);

// �Է��� ������ DB�� ����
// 1. �Խù� ����
String title = multi.getParameter("title");
String writer = multi.getParameter("writer");
String content = multi.getParameter("content");

BoardDAO dao = new BoardDAO();

int boardNo = dao.selectBoardNo();

BoardVO board = new BoardVO();
board.setTitle(title);
board.setWriter(writer);
board.setContent(content);
board.setNo(boardNo);

dao.insert(board);

// 2. �Խù��� ÷������ ����
Enumeration files =  multi.getFileNames();

while(files.hasMoreElements()) {
	
	String fileName = (String)files.nextElement();
	File f = multi.getFile(fileName);
	if(f != null) {
		
		String fileOriName = multi.getOriginalFileName(fileName);
		String fileSaveName = multi.getFilesystemName(fileName);
		
		BoardFileVO fileVO = new BoardFileVO();
		fileVO.setFileOriName(fileOriName);
		fileVO.setFileSaveName(fileSaveName);
		fileVO.setFileSize((int)f.length());
		fileVO.setBoardNo(boardNo);
		
		dao.insertFile(fileVO);
	}
}



// ����÷���� �Է��ڵ�
// String title = request.getParameter("title");
// String writer = request.getParameter("writer");
// String content = request.getParameter("content");

// BoardDAO dao = new BoardDAO();
// BoardVO board = new BoardVO();
// board.setTitle(title);
// board.setWriter(writer);
// board.setContent(content);
//dao.insert(board);
%>

<script>
	alert('�Խù��� ��ϵǾ����ϴ�.');
	location.href = "list.jsp";
</script>























