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
	}

}















