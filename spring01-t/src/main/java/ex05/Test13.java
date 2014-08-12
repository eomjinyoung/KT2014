package ex05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test13 {

	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("ex05/beans.xml");

		/*
		<bean id="car1" class="ex05.Car"/>
		*/
		Car car1 = (Car)ctx.getBean("car1");
		System.out.println("car1:" + car1.hashCode());
		
		/*
		<bean name="car2" class="ex05.Car"/>
		*/
		Car car2 = (Car)ctx.getBean("car2");
		System.out.println("car2:" + car2.hashCode());
		
		/*
		<bean id="car3" name="car3-1 car3-2 car3-3" class="ex05.Car"/>
		*/
		Car car3 = (Car)ctx.getBean("car3");
		System.out.println("car3:" + car3.hashCode());
		
		Car car31 = (Car)ctx.getBean("car3-1");
		System.out.println("car3-1:" + car31.hashCode());
		
		Car car32 = (Car)ctx.getBean("car3-2");
		System.out.println("car3-2:" + car32.hashCode());
		
		Car car33 = (Car)ctx.getBean("car3-3");
		System.out.println("car3-3:" + car33.hashCode());
		
		/*
		<bean name="car4 car4-1 car4-2" class="ex05.Car"/>
		*/
		Car car4 = (Car)ctx.getBean("car4");
		System.out.println("car4:" + car4.hashCode());
		
		Car car41 = (Car)ctx.getBean("car4-1");
		System.out.println("car4-1:" + car41.hashCode());
		
		Car car42 = (Car)ctx.getBean("car4-2");
		System.out.println("car4-2:" + car42.hashCode());
		
		System.out.println("car3 별명들: -----------------------------");
		String[] car3Alias = ctx.getAliases("car3-1");
		for (String alias : car3Alias) {
			System.out.println(alias);
		}
		
		
	}

}















