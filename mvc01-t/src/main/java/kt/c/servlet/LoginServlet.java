package kt.c.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kt.c.dao.LoginDAO;
import kt.c.vo.LoginVO;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		System.out.println("LoginServlet.doGet()...");
		RequestDispatcher rd = request.getRequestDispatcher("/view/auth/login.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		System.out.println("LoginServlet.doPost()...");
		
		LoginVO userVO = new LoginDAO().login(
									new LoginVO()
										.setId(request.getParameter("id"))
										.setPassword(request.getParameter("password")));
		
		if (userVO != null) {
			request.getSession().setAttribute("userVO", userVO);
			RequestDispatcher rd = request.getRequestDispatcher(
					"/view/auth/loginProcess.jsp");
			rd.forward(request, response);
			
		} else {
			// Redirect 방식
			response.sendRedirect("login");
			
			/* Refresh 방식
			response.setHeader("Refresh", "5;url=http://www.naver.com");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>오호라</title></head>");
			out.println("<body>잠시 기다리세요.. 네이버로 이동합니다.</body>");
			out.println("</html>");
			*/
		}
	}
}























