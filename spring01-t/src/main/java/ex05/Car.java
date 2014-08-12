package ex05;

import org.springframework.stereotype.Component;

/* 애노테이션을 이용하여 빈 설정하기 
 * @Component 애노테이션
 * => 스프링 IoC 컨테이너는 이 애노테이션이 붙은 클래스의 인스턴스를 자동 생성한다.
 * => 클래스를 좀 더 상세히 분류하기 위해 스프링은 다음 애노테이션을 추가로 제공한다.
 *    @Controller, @Service, @Repository
 *    즉, 위의 애노테이션 붙은 클래스에 대해서도 인스턴스를 자동으로 생성한다.
 * => 단, 스프링 설정 파일에 이런 애노테이션을 처리할 담당자를 지정해야 한다.
 *    <context:component-scan base-package="탐색 시작 패키지"/>
 * 
 */

@Component
public class Car {
	String model;
	int cc;
	Engine engine;
	
	public Car() {} 
	
	public Car(String model, int cc) {
		this.model = model;
		this.cc = cc;
	}
	
	@Override
  public String toString() {
	  return "Car [model=" + model + ", cc=" + cc + ", engine=" + engine + "]";
  }

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
}
