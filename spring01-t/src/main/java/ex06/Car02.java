package ex06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/* 인스턴스 변수에 @Autowired 붙이기
 * => 기본은 필수 입력 항목
 * => 선택 입력 항목으로 변경 => required 속성을 false로 지정한다.   
 */

//@Component
public class Car02 {
	String model;
	int cc;
	
	//@Autowired // 필수 입력 항목으로 지정한다. 따라서 해당 타입의 의존 객체가 없으면 오류 발생!
	@Autowired(required=false) // 선택 항목이기 때문에 없으면 무시한다.
	Engine engine;
	
	public Car02() {} 
	
	public Car02(String model, int cc) {
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
