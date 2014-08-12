package ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {

	public static void main(String[] args) {
		ApplicationContext 
			ctx = new ClassPathXmlApplicationContext("ex01/beans.xml");

		// 호출될 생성자를 지정한 car2 객체 얻기
		Car p = (Car)ctx.getBean("car2");
		System.out.println(p.getModel());
		System.out.println(p.getCc());
		
		Car p3 = (Car)ctx.getBean("car3");
		System.out.println(p3.getModel());
		System.out.println(p3.getCc());
		
		Car p4 = (Car)ctx.getBean("car4");
		System.out.println(p4.getModel());
		System.out.println(p4.getCc());
		
	}

}
