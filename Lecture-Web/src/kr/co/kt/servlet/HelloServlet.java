package kr.co.kt.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class HelloServlet extends HttpServlet{

	public void init(ServletConfig config) throws ServletException {
		System.out.println("���� �ѹ��� ����Ǵ� init �޼ҵ��Դϴ�.");
	}
	
	public void service(ServletRequest request, ServletResponse reponse) 
		throws ServletException, IOException {

		System.out.println("���� �۾�ó���Ǵ� service �޼ҵ��Դϴ�.");
		System.out.println("����ڰ� ��û�Ҷ����� ȣ��˴ϴ�.");
	}
}













