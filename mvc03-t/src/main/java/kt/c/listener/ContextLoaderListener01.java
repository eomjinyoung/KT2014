package kt.c.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import kt.c.control.BoardDeleteController;
import kt.c.control.BoardDetailController;
import kt.c.control.BoardListController;
import kt.c.control.BoardUpdateController;
import kt.c.control.BoardWriteController;
import kt.c.control.LoginController;
import kt.c.control.LogoutController;
import kt.c.dao.BoardDAO;
import kt.c.dao.LoginDAO;
import kt.c.util.ConnectionFactory;

public class ContextLoaderListener01 implements ServletContextListener {
	ConnectionFactory connectionFactory;
	
	/* 웹 애플리케이션이 시작되면 호출된다.*/
	@Override
  public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ContextLoaderListener.contextInitialized()");
	  // 웹 애플리케이션을 시작할 때 서블릿이나 필터 등이 사용할 데이터 준비 
		ServletContext ctx = sce.getServletContext();
		ctx.setAttribute("contextRoot", ctx.getContextPath());
		
		connectionFactory = new ConnectionFactory();
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.setConnectionFactory(connectionFactory);
		
		LoginDAO loginDAO = new LoginDAO();
		loginDAO.setConnectionFactory(connectionFactory);
		
		BoardListController boardListController = new BoardListController();
		boardListController.setBoardDAO(boardDAO);
		ctx.setAttribute("/board/list.do", boardListController);
		
		LoginController loginController = new LoginController();
		loginController.setLoginDAO(loginDAO);
		ctx.setAttribute("/auth/login.do", loginController);
		
		BoardDetailController boardDetailController = new BoardDetailController();
		boardDetailController.setBoardDAO(boardDAO);
		ctx.setAttribute("/board/detail.do", boardDetailController);
		
		BoardDeleteController boardDeleteController = new BoardDeleteController();
		boardDeleteController.setBoardDAO(boardDAO);
		ctx.setAttribute("/board/delete.do", boardDeleteController);
		
		BoardWriteController boardWriteController = new BoardWriteController();
		boardWriteController.setBoardDAO(boardDAO);
		ctx.setAttribute("/board/write.do", boardWriteController);
		
		BoardUpdateController boardUpdateController = new BoardUpdateController();
		boardUpdateController.setBoardDAO(boardDAO);
		ctx.setAttribute("/board/update.do", boardUpdateController);
		
		ctx.setAttribute("/auth/logout.do", new LogoutController());
  }

	/* 웹 애플리케이션을 종료하기 전에 호출된다.*/
	@Override
  public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ContextLoaderListener.contextDestroyed()");
	  // 웹 애플리케이션을 종료하기 전에 마무리할 작업 수행
	  connectionFactory.closeAll();
  }

}

























