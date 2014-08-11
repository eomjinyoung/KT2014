package kt.c.annotation.ex;

import java.lang.annotation.Annotation;

import kt.c.annotation.Component;

public class Test01 {

	public static void main(String[] args) {
		Car car = new Car();
		
		Class clazz = car.getClass();
		Annotation[] annos = clazz.getAnnotations();
		
		for (Annotation anno : annos) {
			System.out.println(anno.toString());
		}
		
		/* class 변수
		 * - 모든 클래스에 존재하는 변수로, public static final 변수이다.
		 * - 이 변수는 클래스 정보를 다루는 Class 객체의 주소를 갖고 있다.
		 */
		
		Component comp = (Component)clazz.getAnnotation(Component.class);
		System.out.println("=>" + comp.value());
	}

}


















