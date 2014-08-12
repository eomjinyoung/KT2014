package ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test11 {

	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("ex04/beans.xml");

		Object bean = ctx.getBean("car1");
		System.out.println(bean.getClass().getName());

		Object bean2 = ctx.getBean("car2");
		System.out.println(bean2.getClass().getName());
		System.out.println(bean2);
		
		Object bean3 = ctx.getBean("car3");
		System.out.println(bean3.getClass().getName());
		System.out.println(bean3);
		
		Object bean4 = ctx.getBean("car4");
		System.out.println(bean4.getClass().getName());
		System.out.println(bean4);
		
		Object bean5 = ctx.getBean("car5");
		System.out.println(bean5.getClass().getName());
		System.out.println(bean5);
	}

}















