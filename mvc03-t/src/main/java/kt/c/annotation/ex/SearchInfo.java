package kt.c.annotation.ex;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SearchInfo {
	String value(); // 생략불가. 필수 입력.
	int level() default 1; // 프로퍼티를 설정하지 않아도 된다. 생략가능.
	String[] author() default {""}; // 생략가능.
}
