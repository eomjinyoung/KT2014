package kt.c.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import kt.c.control.Controller;

//@WebServlet("*.do")
@SuppressWarnings("serial")
public class DispatcherServlet01 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	  String servletPath = request.getServletPath();
	  response.setContentType("text/html; charset=UTF-8");
	  
	  try {
	  	/* 스프링 컨테이너가 관리하고 있는 페이지 컨트롤러 꺼내기
	  	 * Bean Container == IoC Container 
	  	 */
	  	ApplicationContext iocContainer = 
	  		(ApplicationContext)this.getServletContext()
	  														.getAttribute("beanContainer");
	  	Object obj = iocContainer.getBean(servletPath);
	  	
	  	
	  	if (obj == null || !(obj instanceof Controller)) {
	  		throw new Exception("요청하는 페이지가 없습니다.");
	  	}
	  	
		  Controller pageController = (Controller)obj;
	  
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










