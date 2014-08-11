package kt.c.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//자바의 주석!
// 1) single line 주석: 
//    - 라인 끝까지 주석으로 처리 
//    - 컴파일 후 사라짐
//    - .class 파일에 주석 정보가 없음
/*
 * 2) multi-line 주석: /*에서 시작하여  * / 를 만날 때 까지 주석으로 처리.
 *    - 컴파일 후 사라짐
 *    - .class 파일에 주석 정보가 없음
 */
/**
 * 3) Java document template 주석
 *    - javadoc.exe에서 사용하는 주석
 *    - 자바 소스파일 -> javadoc.exe -> 자바 문서 주석을 추출하여 HTML 형식의 API 문서를 생성함.
 *    - 컴파일 후 사라짐. 
 *    - .class 파일에 주석 정보가 없음
 * @author bitacademy
 *
 */
// 4) annotation
/*
 * - 컴파일러 또는 JVM에게 전달하는 주석
 * - 유지 정책에 따라 다르다.
 *   SOURCE => 컴파일 후 사라짐. 컴파일러가 사용하거나 다른 도구가 소스 코드를 분석할 때 사용할 수 있음.
 *            예) @Override
 *   CLASS => 기본. 컴파일 후 클래스 파일에 저장됨. 컴파일러가 사용하는 주석. JVM은 사용할 수 없음(실행 중에 꺼낼 수 없음)
 *   RUNTIME => 컴파일 후 클래스 파일에 저장됨. JVM이 사용하는 주석(실행 중에 추출할 수 있음)
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
	String value();
}


















