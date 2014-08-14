package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
		System.out.println(
				"===>" + 
				this.getServletConfig().getInitParameter("test"));
		
		System.out.println(
				"===>" +
						this.getServletContext().getInitParameter("test"));
		
		PrintWriter out = resp.getWriter();
		out.println("okoko");
	}
}
