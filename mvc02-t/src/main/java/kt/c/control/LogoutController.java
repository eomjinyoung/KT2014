package kt.c.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutController implements Controller {
	@Override
	public String execute(HttpServletRequest request, 
				HttpServletResponse response) throws Exception {
	  request.getSession().invalidate();
	  return "redirect:" + request.getContextPath(); //=> /mvc01
	}
}
