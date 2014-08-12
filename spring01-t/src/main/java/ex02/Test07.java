package ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test07 {

	public static void main(String[] args) {
		ApplicationContext 
			ctx = new ClassPathXmlApplicationContext("ex02/beans.xml");

		Car p5 = (Car)ctx.getBean("car5");
		System.out.println(p5);
		
		Car p6 = (Car)ctx.getBean("car6");
		System.out.println(p6);
		
		Engine engine2 = (Engine) ctx.getBean("engine2");
		Engine engine3 = (Engine) ctx.getBean("engine2");
		
		/* Object 클래스로부터 상속받은 hashCode()는
		 * 기본으로 인스턴스마다 고유의 4바이트 정수 식별자를 리턴한다.
		 * 
		 * 참고!
		 * String 클래스는 인스턴스가 달라도 같은 문자열이면 같은 hashCode()를 리턴한다.
		 * 왜? 재정의 하였다.
		 */
		System.out.println("p5 = " + p5.getEngine().hashCode());
		System.out.println("p6 = " + p6.getEngine().hashCode());
		System.out.println("engine2 = " + engine2.hashCode());
		System.out.println("engine3 = " + engine3.hashCode());
		
	}

}















