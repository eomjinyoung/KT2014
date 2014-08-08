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
public class DispatcherServlet03 extends HttpServlet {
	HashMap<String,Object> objPool = new HashMap<String,Object>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	  super.init(config);
	  
	  objPool.put("/board/list.do", new BoardListController());
	  objPool.put("/auth/login.do", new LoginController());
	  objPool.put("/board/detail.do", new BoardDetailController());
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	  String servletPath = request.getServletPath();
	  response.setContentType("text/html; charset=UTF-8");
	  
	  try {
		  Controller pageController = (Controller)objPool.get(servletPath);
		  if (pageController == null) {
		  	throw new Exception("요구하는 페이지가 없습니다.");
		  }
	  
		  String viewUrl = pageController.execute(request, response);
		  
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










