package kt.c.test;

import java.util.HashSet;

public class Test02 {

	public static void main(String[] args) {
		/* Set 중복 불가
		 * equals() 리턴 값이 같고, hashCode()의 리턴 값이 같으면 같은 객체로 취급한다.
		 */
		HashSet<String> names = new HashSet<String>();
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
