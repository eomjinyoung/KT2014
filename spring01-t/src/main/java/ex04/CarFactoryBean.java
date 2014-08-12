package ex04;

import org.springframework.beans.factory.config.AbstractFactoryBean;

/* Factory Method 패턴
 * => 스프링 규칙에 따라 팩토리 클래스 만들기 
 * 규칙1) FactoryBean 인터페이스 구현한다. 또는 AbstractFactoryBean 상속 받는다.
 * 규칙2) getObjectType() 재정의 한다. 리턴할 객체의 클래스 타입을 알려주는 것이다.
 * 규칙3) createInstance() 재정의 한다. 객체를 리턴하는 팩토리 메서드이다.
 * 기타) 객체를 생성하는데 필요한 정보가 있다면 프로퍼티로 받는다.
 * 관례) 보통 스프링 규칙에 따라 만든 팩토리 클래스는 접미사로 FactoryBean을 붙인다.
 */
public class CarFactoryBean extends AbstractFactoryBean<Car>{
	String model;
	
	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public Class<?> getObjectType() {
	  return Car.class;
	}
	
	@Override
	protected Car createInstance() throws Exception {
		Car car = new Car();
		
		if (model.equals("tico")) {
			car.setModel("티코");
			car.setCc(800);
			Engine e = new Engine();
			e.setMaker("대우자동차");
			e.setHorsePower(120);
			car.setEngine(e);
			return car;
			
		} else if (model.equals("sonata")) {
			car.setModel("소나타");
			car.setCc(1998);
			Engine e = new Engine();
			e.setMaker("현대자동차");
			e.setHorsePower(275);
			car.setEngine(e);
			return car;
			
		} else {
			return null;
		}
	}
}
