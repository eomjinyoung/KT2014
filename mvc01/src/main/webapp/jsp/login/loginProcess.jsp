<%@page import="kr.co.kt.login.db.LoginDAO"%>
<%@page import="kr.co.kt.login.db.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");

	// ��û��ü���� ������ ���� VO�� ����
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	LoginVO loginVO = new LoginVO();
	loginVO.setId(id);
	loginVO.setPassword(password);
	
	// �α��� ����(DB) 
	// login() ���ϰ�          null : ����
	//               not null : ����
	LoginDAO dao = new LoginDAO();
	LoginVO userVO = dao.login(loginVO);
	
	String msg = "";
	String url = "";
	
	if(userVO != null) {
		
		session.setAttribute("userVO", userVO);
		
		if(userVO.getType().equalsIgnoreCase("S")) {
			msg = "�����ڴ� ȯ���մϴ�	";
		} else {
			msg = userVO.getId() + "�� ȯ���մϴ�.";
		}
		
		url = "/Mission-Web";
		
	} else {
		msg = "ID �Ǵ� PASSWORD�� �߸� �ԷµǾ����ϴ�";
		url = "login.jsp";
	}
%>

<script>
	alert('<%= msg %>');
	location.href = "<%= url %>";
</script>

ss












