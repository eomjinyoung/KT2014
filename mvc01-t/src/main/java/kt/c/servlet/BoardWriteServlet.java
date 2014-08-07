package kt.c.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kt.board.db.BoardDAO;
import kr.co.kt.board.db.BoardFileVO;
import kr.co.kt.board.db.BoardVO;
import kr.co.kt.util.BitFileNamePolicy;
import kt.c.vo.LoginVO;

import com.oreilly.servlet.MultipartRequest;

@WebServlet("/board/write")
@SuppressWarnings("serial")
public class BoardWriteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/view/board/writeForm.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		String saveFolder = this.getServletContext().getRealPath("/upload");

		MultipartRequest multi = new MultipartRequest(
				request
				, saveFolder			// 저장될 경로
				, 1024 * 1024 * 3 		// 파일에 올릴 최대크기 : 3MB
				, "euc-kr"				// 인코딩 타입
				, new BitFileNamePolicy()
				);

		String title = multi.getParameter("title");
		
		LoginVO loginVO = (LoginVO)request.getSession().getAttribute("userVO");
		String writer = loginVO.getId();
		
		String content = multi.getParameter("content");

		BoardDAO dao = new BoardDAO();

		int boardNo = dao.selectBoardNo();

		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		board.setNo(boardNo);

		dao.insert(board);

		// 2. 게시물의 첨부파일 저장
		Enumeration<?> files =  multi.getFileNames();

		while(files.hasMoreElements()) {
			
			String fileName = (String)files.nextElement();
			File f = multi.getFile(fileName);
			if(f != null) {
				
				String fileOriName = multi.getOriginalFileName(fileName);
				String fileSaveName = multi.getFilesystemName(fileName);
				
				BoardFileVO fileVO = new BoardFileVO();
				fileVO.setFileOriName(fileOriName);
				fileVO.setFileSaveName(fileSaveName);
				fileVO.setFileSize((int)f.length());
				fileVO.setBoardNo(boardNo);
				
				dao.insertFile(fileVO);
			}
		}
		
		response.sendRedirect("list");

	}

}



















