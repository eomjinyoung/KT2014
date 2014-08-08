package kt.c.control;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kt.c.dao.BoardDAO;
import kt.c.util.BitFileNamePolicy;
import kt.c.vo.BoardFileVO;
import kt.c.vo.BoardVO;
import kt.c.vo.LoginVO;

import com.oreilly.servlet.MultipartRequest;

public class BoardWriteController implements Controller {
	@Override
	public String execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		if (request.getMethod().equals("GET")) {
			return "/view/board/writeForm.jsp";

		} else {
			String saveFolder = request.getServletContext().getRealPath("/upload");
	
			MultipartRequest multi = new MultipartRequest(
					request
					, saveFolder			// 저장될 경로
					, 1024 * 1024 * 3 		// 파일에 올릴 최대크기 : 3MB
					, "UTF-8"				// 인코딩 타입
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
			
			return "redirect:list.do";
		}

	}

}



















