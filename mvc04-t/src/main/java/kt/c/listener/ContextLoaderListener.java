package kt.c.listener;

import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import kt.c.annotation.Component;

import org.reflections.Reflections;

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
			ctx.setAttribute("dataSource", dataSource);

			createComponents();
			injectDependencies();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void createComponents() throws Exception {
		Reflections reflections = new Reflections("kt.c");
		Set<Class<?>> classList = reflections.getTypesAnnotatedWith(Component.class);
		Component compAnno = null;
		
		for (Class<?> clazz : classList) {
			compAnno = (Component)clazz.getAnnotation(Component.class);
			if (compAnno != null) { 
				ctx.setAttribute(compAnno.value(), clazz.newInstance());
			}
		}
	}
	
	private void injectDependencies() throws Exception {
		// ServletContext에 들어 있는 객체를 꺼내서 그 객체가 사용하는 의존 객체를 주입한다.
		
		// 1) ServletContext 저장소에 저장된 객체를 꺼내기 위해 먼저 이름 목록을 알아낸다.
		Enumeration<String> nameList = ctx.getAttributeNames();
		
		// 2) 이름 목록에서 이름을 하나씩 꺼낸다.
		String name = null;
		Object obj = null;
		Class<?> clazz = null;
		Method[] methodList = null;
		Class<?> paramClazz = null;
		Object paramObj = null;
		
		while(nameList.hasMoreElements()) { // 꺼낼 이름이 있느냐?
			name = nameList.nextElement(); // 목록에서 이름을 하나 꺼내라.
			
			// 3) 이름으로 ServletContext에 저장된 객체를 꺼낸다.
			obj = ctx.getAttribute(name);
			
			// 4) 꺼낸 객체에 대해 클래스 정보를 알아낸다.
			clazz = obj.getClass();
			
			// 5) 클래스 정보 관리 객체로부터 그 클래스가 갖고 있는 메서드 목록을 꺼낸다.
			methodList = clazz.getMethods();
			
			// 6) 메서드 목록에서 setter 메서드를 찾는다.
			for (Method method : methodList) {
				if (method.getName().startsWith("set") // 메서드 이름이 set으로 시작하고
						&& method.getParameterTypes().length == 1 // 파라미터는 한 개이어야 한다.
						&& method.getParameterTypes()[0] != String.class) // 스트링 파라미터는 제외  
				{ 
					// 7) setter 메서드가 원하는 파라미터가 어떤 클래스 타입인지 알아낸다. 단, 첫번째 파라미터의 클래스 타입
					paramClazz = method.getParameterTypes()[0];
					
					// 8) setter 메서드의 파라미터 정보를 알아 냈으면, 그런 타입의 객체를 ServletContext에서 찾는다.
					paramObj = findObject(paramClazz);
					
					// 9) setter 메서드의 파라미터 타입과 일치하는 객체를 ServletContext에서 찾았으면 
					//    해당 setter 메서드를 호출한다.
					if (paramObj != null) {
						method.invoke(obj, paramObj); // 메서드 호출
					}
				}
			}
		}
	}
	
	private Object findObject(Class<?> clazz) {
		// ServletContext 저장소에서 clazz의 인스턴스를 찾아 리턴한다.
		Enumeration<String> nameList = ctx.getAttributeNames();
		String name = null;
		Object obj = null;
		
		while (nameList.hasMoreElements()) { // 이름 목록에서 꺼낼 이름이 있느냐?
			name = nameList.nextElement(); // 이름을 하나 꺼내라.
			obj = ctx.getAttribute(name);  // ServletContext에서 name으로 객체를 찾는다.
			
			if (clazz.isInstance(obj)) {
				return obj;
			}
		}
		
		return null;
	}

	/* 웹 애플리케이션을 종료하기 전에 호출된다.*/
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ContextLoaderListener.contextDestroyed()");
		// 웹 애플리케이션을 종료하기 전에 마무리할 작업 수행
	}

}

























