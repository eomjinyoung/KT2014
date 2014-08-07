package kt.c.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kt.board.db.BoardDAO;

@SuppressWarnings("serial")
@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	int no = Integer.parseInt(request.getParameter("no"));

  	BoardDAO dao = new BoardDAO();
  	dao.deleteFile(no);
  	dao.delete(no);
  	
  	String ip = request.getLocalAddr();
  	
  	response.sendRedirect("list?who=" + ip);
  }
}














