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
		
		System.out.println("doGet 메소드 호출");
		
		/*
		 * 1. 요청객체에서 넘겨준 데이터를 추출
		 */
		String method = req.getMethod();
		String uri    = req.getRequestURI();
		String id     = req.getParameter("title");
		
	//	id = new String(id.getBytes("iso8859_1"), "euc-kr");
		
		/*
		 * 2-1. 콘솔창에 출력
		 */
		System.out.println(method);
		System.out.println(uri);
		System.out.println(id);
		
		/*
		 * 2-2 서버에서 클라이언트(웹브라우저)에게 정보 전달
		 *     서버가 html 전달 -> 클라이언트 출력
		 *     일반 텍스트 : getWriter()
		 *     이미지          : getOutputStream()
		 */
		resp.setContentType("text/html;charset=euc-kr");
		PrintWriter out = resp.getWriter();
		
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append(" <head>");
		sb.append("   <title>메소드 호출 방식 </title>");
		sb.append(" </head>");
		sb.append(" <body>");
		sb.append("    요청방식 : " + method + "<br/>");
		sb.append("    요청 URI : " + uri + "<br/>");
		sb.append("    파라미터(id) : " + id + "<br/>");
		sb.append(" </body>");
		sb.append("</html>");
		
		out.println(sb.toString());
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doPost 메소드 호출");
		
		// post방식만 지원 서블릿2.3이후
		req.setCharacterEncoding("euc-kr");
		
		String method = req.getMethod();
		String uri    = req.getRequestURI();
		String id     = req.getParameter("title");
		
		resp.setContentType("text/html;charset=euc-kr");
		PrintWriter out = resp.getWriter();
		
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append(" <head>");
		sb.append("   <title>메소드 호출 방식 </title>");
		sb.append(" </head>");
		sb.append(" <body>");
		sb.append("    요청방식 : " + method + "<br/>");
		sb.append("    요청 URI : " + uri + "<br/>");
		sb.append("    파라미터(id) : " + id + "<br/>");
		sb.append(" </body>");
		sb.append("</html>");
		
		out.println(sb.toString());
		out.close();
	}

}







