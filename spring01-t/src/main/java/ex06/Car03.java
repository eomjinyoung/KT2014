package ex06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/* 인스턴스 변수에 @Autowired 붙이기
 * => 기본은 필수 입력 항목
 * => 선택 입력 항목으로 변경 => required 속성을 false로 지정한다.   
 * => 같은 타입의 객체가 여러 개 있을 경우 오류 발생! 
 *    해결책? 
 *    주입할 의존 객체의 이름을 지정한다. => @Qualifier 애노테이션을 사용한다.
 */

@Component
public class Car03 {
	String model;
	int cc;
	
	@Autowired
	@Qualifier("engine2")
	Engine engine;
	
	public Car03() {} 
	
	public Car03(String model, int cc) {
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
