package ex05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test12 {

	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("ex05/beans.xml");

		//@Component의 value 값을 설정하지 않으면,
		// 인스턴스는 클래스 이름(첫 알파벳 소문자)으로 보관한다.
		Car car1 = (Car)ctx.getBean("car");
		System.out.println(car1);
	}

}















