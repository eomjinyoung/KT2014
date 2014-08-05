package kr.co.kt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		
		String context = request.getContextPath();
		String uri = request.getRequestURI();
		uri = uri.substring(context.length());
		String callPage = "";
		
		try {
			
			HandleMapping mappings = new HandleMapping();
			Controller control = mappings.getController(uri);
			callPage = control.handleRequest(request, response);
		} catch(Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
		dispatcher.forward(request, response);
		
	}
}
















