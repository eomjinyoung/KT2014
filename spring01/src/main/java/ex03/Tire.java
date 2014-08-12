package ex03;

public class Tire {
	String diameter;

	public Tire() {}
	
	public Tire(String diameter) {
		this.diameter = diameter;
	}
	
	@Override
  public String toString() {
	  return "Tire [diameter=" + diameter + "]";
  }

	public String getDiameter() {
		return diameter;
	}

	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}
}
