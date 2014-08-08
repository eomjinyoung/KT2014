package kt.c.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {

	/* 웹 애플리케이션이 시작되면 호출된다.*/
	@Override
  public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ContextLoaderListener.contextInitialized()");
	  // 웹 애플리케이션을 시작할 때 서블릿이나 필터 등이 사용할 데이터 준비 
		ServletContext ctx = sce.getServletContext();
		ctx.setAttribute("contextRoot", ctx.getContextPath());
	  
  }

	/* 웹 애플리케이션을 종료하기 전에 호출된다.*/
	@Override
  public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ContextLoaderListener.contextDestroyed()");
	  // 웹 애플리케이션을 종료하기 전에 마무리할 작업 수행
	  
  }

}
