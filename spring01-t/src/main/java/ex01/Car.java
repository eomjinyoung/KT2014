package ex01;

public class Car {
	String model;
	int cc;
	String maker;
	
	public Car() {
		System.out.println("Car() 호출됨...");
	} // 기본 생성자. 생성자가 없으면 자동으로 만든다.
	
	public Car(String model, int cc) {
		System.out.println("Car(model,cc) 호출됨...");
		this.model = model;
		this.cc = cc;
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
}
