package kr.co.kt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CopyOfFrontController extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		System.out.println("서비스 호출...");
		
		String context = request.getContextPath();
		String uri = request.getRequestURI();
		uri = uri.substring(context.length());
		
		System.out.println("호출된 uri : " + uri);
		
		String callPage = "";
		Controller control = null;
		
		try {
			
			switch(uri) {
			case "/list.do" : 
//				ListController list = new ListController();
//				callPage = list.handleRequest(requuest, response);
				control = new ListController();
				break;
			case "/writeForm.do" : 
				control = new WriteFormController();
				break;
			}
			
			
			callPage = control.handleRequest(request, response);
		} catch(Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
		dispatcher.forward(request, response);
		
	}
}
















