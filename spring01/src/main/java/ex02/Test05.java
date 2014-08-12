package ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test05 {

	public static void main(String[] args) {
		ApplicationContext 
			ctx = new ClassPathXmlApplicationContext("ex02/beans.xml");

		Car p1 = (Car)ctx.getBean("car1");
		System.out.println(p1);
		
		Car p2 = (Car)ctx.getBean("car2");
		System.out.println(p2);
		
		if (p1.getEngine() == p2.getEngine()) {
			System.out.println("p1의 엔지과 p2의 엔진은 같은 객체이다.");
		}
		
		Engine engine1 = (Engine)ctx.getBean("engine1");
		if (p1.getEngine() == engine1) {
			System.out.println("p1의 엔진과 engine1은 같은 객체이다.");
		}
		
	}

}
