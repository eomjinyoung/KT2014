<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<%
	// ���� ������ ���� ��ȿ�ð� Ȯ��
	int interval = session.getMaxInactiveInterval();
	String id = session.getId();
	
	// ������ ��ȿ�ð��� 2�ʷ� ����
	session.setMaxInactiveInterval(2);
	// ���� ����Ǵ� ���� ��ȿ�ð� Ȯ��
	int interval2 = session.getMaxInactiveInterval();
	
	// ���������� ������ �ð�
	long time = session.getLastAccessedTime();
	Date d = new Date(time);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� hh�� mm�� ss��");
%>

<h2>������ ���� ��ȿ�ð� : <%= interval %>��</h2>
<h2>������ ���̵� : <%= id %></h2>
<h2>������ ����� ��ȿ�ð� : <%= interval2 %></h2>
<h2>������ ���� �ð� : <%= sdf.format(d) %></h2>











