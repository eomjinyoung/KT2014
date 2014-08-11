package kt.c.annotation.ex;

public class Test03 {

	@SuppressWarnings("unused")
  public static void main(String[] args) throws Exception {
		Car2 p = new Car2();
		Class clazz1 = p.getClass();
		
		
		Class clazz2 = Class.forName("kt.c.annotation.ex.Car2");
		Car2 p2 = (Car2)clazz2.newInstance();

	}

}
