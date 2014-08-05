package kr.co.kt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kt.dao.BoardDAO;
import kr.co.kt.vo.BoardVO;

public class ListController implements Controller{

	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectAll();
		
		request.setAttribute("list", list);
		
		return "/board/list.jsp";
	}
}
