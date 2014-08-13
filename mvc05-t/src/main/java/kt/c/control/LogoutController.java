package kt.c.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

//@Component("/auth/logout.do")
public class LogoutController implements ControllerX {
	@Override
	public String execute(HttpServletRequest request, 
				HttpServletResponse response) throws Exception {
	  request.getSession().invalidate();
	  return "redirect:" + request.getContextPath(); //=> /mvc01
	}
}
