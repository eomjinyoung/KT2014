package kr.co.kt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MethodServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("doGet �޼ҵ� ȣ��");
		
		/*
		 * 1. ��û��ü���� �Ѱ��� �����͸� ����
		 */
		String method = req.getMethod();
		String uri    = req.getRequestURI();
		String id     = req.getParameter("title");
		
	//	id = new String(id.getBytes("iso8859_1"), "euc-kr");
		
		/*
		 * 2-1. �ܼ�â�� ���
		 */
		System.out.println(method);
		System.out.println(uri);
		System.out.println(id);
		
		/*
		 * 2-2 �������� Ŭ���̾�Ʈ(��������)���� ���� ����
		 *     ������ html ���� -> Ŭ���̾�Ʈ ���
		 *     �Ϲ� �ؽ�Ʈ : getWriter()
		 *     �̹���          : getOutputStream()
		 */
		resp.setContentType("text/html;charset=euc-kr");
		PrintWriter out = resp.getWriter();
		
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append(" <head>");
		sb.append("   <title>�޼ҵ� ȣ�� ��� </title>");
		sb.append(" </head>");
		sb.append(" <body>");
		sb.append("    ��û��� : " + method + "<br/>");
		sb.append("    ��û URI : " + uri + "<br/>");
		sb.append("    �Ķ����(id) : " + id + "<br/>");
		sb.append(" </body>");
		sb.append("</html>");
		
		out.println(sb.toString());
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doPost �޼ҵ� ȣ��");
		
		// post��ĸ� ���� ����2.3����
		req.setCharacterEncoding("euc-kr");
		
		String method = req.getMethod();
		String uri    = req.getRequestURI();
		String id     = req.getParameter("title");
		
		resp.setContentType("text/html;charset=euc-kr");
		PrintWriter out = resp.getWriter();
		
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append(" <head>");
		sb.append("   <title>�޼ҵ� ȣ�� ��� </title>");
		sb.append(" </head>");
		sb.append(" <body>");
		sb.append("    ��û��� : " + method + "<br/>");
		sb.append("    ��û URI : " + uri + "<br/>");
		sb.append("    �Ķ����(id) : " + id + "<br/>");
		sb.append(" </body>");
		sb.append("</html>");
		
		out.println(sb.toString());
		out.close();
	}

}







