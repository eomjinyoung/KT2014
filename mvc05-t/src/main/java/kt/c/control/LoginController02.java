package kt.c.control;

import javax.servlet.http.HttpServletRequest;

import kt.c.dao.LoginDAO;
import kt.c.vo.LoginVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
//@RequestMapping("/auth/login") // 각 요청 핸들러에서 URL을 정보를 설정할 수 있다.
public class LoginController02 {
	@Autowired
	LoginDAO loginDAO;

	@RequestMapping(value="/auth/login", method=RequestMethod.GET)
	public String loginForm() throws Exception {
		return "/view/auth/login.jsp";
	}
	
	@RequestMapping(value="/auth/login", method=RequestMethod.POST)
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























