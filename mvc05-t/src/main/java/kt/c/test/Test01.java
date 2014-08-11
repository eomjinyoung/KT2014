package kt.c.test;

import java.util.ArrayList;

public class Test01 {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		names.add(new String("홍길동"));
		names.add(new String("홍길동"));
		names.add(new String("홍길동"));
		names.add(new String("홍길동"));
		
		System.out.println(names.size());
		
		for (String s : names) {
			System.out.println(s);
		}

	}

}
