package kt.c.listener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import kt.c.control.BoardDeleteController;
import kt.c.control.BoardDetailController;
import kt.c.control.BoardListController;
import kt.c.control.BoardUpdateController;
import kt.c.control.BoardWriteController;
import kt.c.control.LoginController;
import kt.c.control.LogoutController;
import kt.c.dao.BoardDAO;
import kt.c.dao.LoginDAO;

public class ContextLoaderListener implements ServletContextListener {
	DataSource dataSource;
	
	/* 웹 애플리케이션이 시작되면 호출된다.*/
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ContextLoaderListener.contextInitialized()");
		// 웹 애플리케이션을 시작할 때 서블릿이나 필터 등이 사용할 데이터 준비 
		ServletContext ctx = sce.getServletContext();
		ctx.setAttribute("contextRoot", ctx.getContextPath());

		try {
			// InitialContext : JNDI(Java Naming and Directory Interface) 자원을  조회할 때 사용하는 도구.
			// JNDI? DB 커넥션, 스레드 등 자바 자원에 대해 이름을 부여하고 디렉토리 형식으로 분류 관리하는 서비스.
			// 유사개념: 웹 도메인 서비스 
			Context initCtx = new InitialContext();
			dataSource = (DataSource)initCtx.lookup("java:/comp/env/jdbc/xe");
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.setDataSource(dataSource);

			LoginDAO loginDAO = new LoginDAO();
			loginDAO.setDataSource(dataSource);

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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* 웹 애플리케이션을 종료하기 전에 호출된다.*/
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ContextLoaderListener.contextDestroyed()");
		// 웹 애플리케이션을 종료하기 전에 마무리할 작업 수행
	}

}

























