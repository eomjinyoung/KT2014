package kt.c.control;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import kt.c.dao.LoginDAO;
import kt.c.vo.LoginVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
@RequestMapping("/auth") // 클래스 선언부에서 기본 URL을 지정하고, 요청 핸들러(메서드)에서는 나머지 URL 지정
public class AuthController02 {
	@Autowired
	LoginDAO loginDAO;
	
	/* ServletContext 객체는 요청 핸들러의 파라미터로 받을 수 없다.
	 * 대신, 인스턴스 변수를 통해 주입 받을 수 있다.
	 */
	@Autowired
	ServletContext servletContext;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() throws Exception {
		return "/view/auth/login.jsp";
	}
	
	/* 요청 파라미터 이름과 메서드 파라미터 이름이 같을 때는 애노테이션을 생략한다.*/
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(
			/*@RequestParam("id")*/ String id, /* 요청 파라미터(id) 값을 받기 위한 변수 */ 
			/*@RequestParam("password")*/ String password,	/* 요청 파라미터(password) 값을 받기 위한 변수*/
			HttpSession session) throws Exception {		
		LoginVO userVO = loginDAO.login(
				new LoginVO().setId(id).setPassword(password));
		
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























