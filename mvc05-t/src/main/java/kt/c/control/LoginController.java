package kt.c.control;

import javax.servlet.http.HttpServletRequest;

import kt.c.dao.LoginDAO;
import kt.c.vo.LoginVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
@RequestMapping("/auth") // 클래스 선언부에서 기본 URL을 지정하고, 요청 핸들러(메서드)에서는 나머지 URL 지정
public class LoginController {
	@Autowired
	LoginDAO loginDAO;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() throws Exception {
		return "/view/auth/login.jsp";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest request) throws Exception {		
		LoginVO userVO = loginDAO.login(
									new LoginVO()
										.setId(request.getParameter("id"))
										.setPassword(request.getParameter("password")));
		
		if (userVO != null) {
			request.getSession().setAttribute("userVO", userVO);
			return "/view/auth/loginProcess.jsp";
			
		} else {
			return "redirect:login.do";
		}
	}
	
}























