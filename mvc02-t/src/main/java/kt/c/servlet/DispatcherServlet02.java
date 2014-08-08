package kt.c.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kt.c.control.BoardDetailController;
import kt.c.control.BoardListController;
import kt.c.control.Controller;
import kt.c.control.LoginController;

//@WebServlet("*.do")
@SuppressWarnings("serial")
public class DispatcherServlet02 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	  String servletPath = request.getServletPath();
	  response.setContentType("text/html; charset=UTF-8");
	  
	  try {
		  Controller pageController = null;
		  String viewUrl = null;
		  
		  switch (servletPath) {
		  case "/board/list.do": pageController = new BoardListController(); break;
		  case "/auth/login.do": pageController = new LoginController(); break;
		  case "/board/detail.do": pageController = new BoardDetailController(); break;
		  default:
		  	throw new Exception("요구하는 페이지가 없습니다.");
		  }
	  
		  viewUrl = pageController.execute(request, response);
		  
		  if (viewUrl.startsWith("redirect:")) {
		  	response.sendRedirect(viewUrl.substring(9));
		  
		  } else {
		  	RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
		  	rd.include(request, response);
		  }
		  
	  } catch(Throwable error) {
	  	StringWriter out = new StringWriter();
	  	PrintWriter out2 = new PrintWriter(out);
	  	error.printStackTrace(out2);
	  	
	  	request.setAttribute("error", out.toString());
	  	out2.close();
	  	out.close();
	  	
	  	RequestDispatcher rd = request.getRequestDispatcher("/view/error.jsp");
		  rd.include(request, response);
	  }
	}
}










