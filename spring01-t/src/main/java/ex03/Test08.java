package ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test08 {

	public static void main(String[] args) {
		ApplicationContext 
			ctx = new ClassPathXmlApplicationContext("ex03/beans.xml");

		Car car1 = (Car)ctx.getBean("car1");
		String[] tires = car1.getTires();
		
		for(String tire : tires) {
			System.out.println(tire);
		}
		
	}

}















