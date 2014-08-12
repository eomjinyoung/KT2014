package ex06;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

//@Component("engine1")
public class Engine {
	String maker;
	int horsePower;
	
	@Override
  public String toString() {
	  return "Engine [maker=" + maker + ", horsePower=" + horsePower + "]";
  }
	
	public String getMaker() {
		return maker;
	}
	
  @Required
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public int getHorsePower() {
		return horsePower;
	}
	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}
}
