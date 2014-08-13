package kt.c.control;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import kt.c.dao.LoginDAO;
import kt.c.vo.LoginVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
@RequestMapping("/auth") // 클래스 선언부에서 기본 URL을 지정하고, 요청 핸들러(메서드)에서는 나머지 URL 지정
public class AuthController03 {
	@Autowired
	LoginDAO loginDAO;
	
	@Autowired
	ServletContext servletContext;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() throws Exception {
		return "/view/auth/login.jsp";
	}
	
	/* 요청 핸들러에 요청 파라미터 값을 받을 VO 객체를 선언하면 요청 파라미터 값을 VO 객체에 바로 받는다. 
	 * 단 요청 파라미터의 이름과 객체의 프로퍼티 이름이 같아야 한다.*/
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(LoginVO loginVO, HttpSession session) throws Exception {	
		System.out.println("오호라..1");
		LoginVO userVO = loginDAO.login(loginVO);
		
		if (userVO != null) {
			session.setAttribute("userVO", userVO);
			return "/view/auth/loginProcess.jsp";
			
		} else {
			return "redirect:login.do";
		}
	}
	
	@RequestMapping("/logout") // method 프로퍼티를 지정하지 않으면 모두 허용.
	public String execute(HttpSession session) {
	  session.invalidate();
	  return "redirect:/"; // 스프링에서 redirect URL의 루트(/)는 웹 애플리케이션 루트를 의미함.
	}
	
}























