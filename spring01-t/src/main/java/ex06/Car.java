package ex06;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

/* 인스턴스 변수에 @Autowired 붙이기
 * => 기본은 필수 입력 항목
 * => 선택 입력 항목으로 변경 => required 속성을 false로 지정한다.   
 * => 같은 타입의 객체가 여러 개 있을 경우 오류 발생! 
 *    해결책? 
 *    주입할 의존 객체의 이름을 지정한다. => @Qualifier 애노테이션을 사용한다.
 * => 또다른 해결책 JSR-250 규약에서 제안한 애노테이션 사용하기
 *    @Resource(name="의존객체아이디 또는 이름") <= 타입이 아니라 이름을 객체를 찾아서 주입한다.
 *         
 * @Required 애노테이션
 * => 프로퍼티를 필수 입력 항목으로 만들기. 
 * => setter 메서드에 선언 가능. 인스턴스 변수에 선언 불가능.                                 
 */

@Component
public class Car {
	String model;
	int cc;
	
	@Resource(name="engine4")
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
