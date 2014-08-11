package kt.c.listener;

import java.io.File;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import kt.c.annotation.Component;

public class ContextLoaderListener implements ServletContextListener {
	ServletContext ctx;
	DataSource dataSource;
	
	/* 웹 애플리케이션이 시작되면 호출된다.*/
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ContextLoaderListener.contextInitialized()");
		// 웹 애플리케이션을 시작할 때 서블릿이나 필터 등이 사용할 데이터 준비 
		ctx = sce.getServletContext();
		ctx.setAttribute("contextRoot", ctx.getContextPath());

		try {
			// InitialContext : JNDI(Java Naming and Directory Interface) 자원을  조회할 때 사용하는 도구.
			// JNDI? DB 커넥션, 스레드 등 자바 자원에 대해 이름을 부여하고 디렉토리 형식으로 분류 관리하는 서비스.
			// 유사개념: 웹 도메인 서비스 
			Context initCtx = new InitialContext();
			dataSource = (DataSource)initCtx.lookup("java:/comp/env/jdbc/xe");
			


			
			/* @Component 애노테이션이 붙은 클래스 이름 알아내기
			 * => 페이지 컨트롤러와 DAO 객체에 @Component 애노테이션이 붙어 있다.
			 * => 경로: /WEB-INF/classes/kt/c/control, /WEB-INF/classes/kt/c/dao
			 */
			String[] pathList = new String[]{
					ctx.getRealPath("/WEB-INF/classes/kt/c/control"),
					ctx.getRealPath("/WEB-INF/classes/kt/c/dao")};
			createComponents(pathList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void createComponents(String[] pathList) throws Exception {
		File dir = null;
		String absolutePath = null;
		int index = 0;
		String packageName = null;
		String filename = null;
		Class<?> clazz = null;
		Component compAnno = null;
		
		for (String path : pathList) {
			dir = new File(path);
			//System.out.println(dir.getName() + "---------------------------");
			//System.out.println(dir.getAbsolutePath());
			
			absolutePath = dir.getAbsolutePath();
			index = absolutePath.indexOf("kt\\c");
			packageName = absolutePath.substring(index).replace("\\", ".");
			//System.out.println(packageName);
			
			File[] files = dir.listFiles();
			for (File file : files) {
				filename = file.getName();
				if (filename.endsWith(".class")) {
					//System.out.println(filename);
					// 패키지명+클래스명(.class 확장자 제거) => 클래스 로딩 
					clazz = Class.forName(
							packageName + "." + filename.replace(".class", ""));
					
					// 클래스 정보로부터 Component 애노테이션 객체 꺼낸다.
					compAnno = (Component)clazz.getAnnotation(Component.class);
					if (compAnno != null) { // 해당 클래스 Component 애노테이션이 있다면,
						//System.out.println("***" + compAnno.value()); // value 프로퍼티 값을 출력한다.
						ctx.setAttribute(compAnno.value(), clazz.newInstance());
					}
				}
			}
		}
	}
	
	private void injectDependencies() throws Exception {
		// ServletContext에 들어 있는 객체를 꺼내서 그 객체가 사용하는 의존 객체를 주입한다.
		
	}
	
	

	/* 웹 애플리케이션을 종료하기 전에 호출된다.*/
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ContextLoaderListener.contextDestroyed()");
		// 웹 애플리케이션을 종료하기 전에 마무리할 작업 수행
	}

}

























