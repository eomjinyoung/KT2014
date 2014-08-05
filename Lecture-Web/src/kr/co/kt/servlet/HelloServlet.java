package kr.co.kt.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class HelloServlet extends HttpServlet{

	public void init(ServletConfig config) throws ServletException {
		System.out.println("최초 한번만 실행되는 init 메소드입니다.");
	}
	
	public void service(ServletRequest request, ServletResponse reponse) 
		throws ServletException, IOException {

		System.out.println("실제 작업처리되는 service 메소드입니다.");
		System.out.println("사용자가 요청할때마다 호출됩니다.");
	}
}













