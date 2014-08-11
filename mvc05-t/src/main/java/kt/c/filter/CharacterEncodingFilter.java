package kt.c.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

	/* 필터 객체가 생성될 때 딱 한 번 호출된다.*/
	@Override
  public void init(FilterConfig filterConfig) throws ServletException {
	  // 필터가 작업을 수행하는데 필요한 준비를 하는 명령어를 작성한다.
	  
  }

	/* 필터에 연결된 URL로 요청이 들어올 때 마다 호출됨 */
	@Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
	  //다음 필터나 서블릿으로 실행을 위임하기 전에 수행할 작업
		System.out.println("CharacterEncodingFilter 사전 작업 수행...");
		request.setCharacterEncoding("UTF-8");
		
		//다음 필터나 서블릿에 실행을 위임
		chain.doFilter(request, response);
		
		//다음 필터나 서블릿의 실행이 완료된 다음 수행할 작업
		System.out.println("CharacterEncodingFilter 마무리 작업 수행...");
  }

	/* 웹 애플리케이션이 종료될 때 딱 한번 호출됨*/
	@Override
  public void destroy() {
	  // 필터가 작업하는 동안 사용했던 자원을 해제하는 명령어를 작성한다.
	  
  }

}









