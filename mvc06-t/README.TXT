[8/8]
1) Front Controller 디자인 패턴 적용(mvc02)
2) Dependency Injection 적용(mvc03)
3) Pooling 기법 (mvc03)
=> 객체 생성에 시간이 오래 걸리는 경우 미리 객체를 생성해 놓고 빌리는 방식으로 사용하는 것.
=> 디자인 패턴: Flyweight 패턴 

[8/11]
4) JNDI를 이용한 DataSource 사용
. /Servers/Tomcat.../context.xml에  DataSource 설정
. 톰캣 서버의 DataSource를 사용하기 위해 web.xml에 설정한다.
. InitialContext의 lookup()으로 DataSource를 찾는다.
5) 애노테이션을 이용하여 객체 생성 자동화 하기
. 애노테이션 정의
. 애노테이션을 사용
. 애노테이션 정보를 추출
. 애노테이션을 페이지 컨트롤러, DAO에 적용
. ContextLoaderListener에서 애노테이션 정보를 추출하여 
     페이지 컨트롤러와 DAO를 자동 생성
. Google Code Reflections API를 사용하여 클래스 찾기
6) 스프링 프레임워크의 빈 컨테이너 사용하기
. ContextLoaderListener에  스프링 빈 컨테이너 객체 준비
. 스프링 설정 파일 작성(kt/c/conf/application-context.xml)
  . <context:component-scan> => context 네임스페이스 임포트
  . JNDI DataSource 빈 설정 추가
. 페이지 컨트롤러와 DAO의 애노테이션을 스프링 애노테이션으로 바꾸기
. 의존 객체 주입을 자동화하기 위해 setter 메서드에 @Autowired 선언한다.
. setter 없이 인스턴스 변수에 @Autowired 선언해도 된다.
. 프론트 컨토를러 DispatcherServlet을 변경한다.
. web.xml에서 DataSource 참조 정보 제거

[8/12]
1) 스프링 IoC 컨테이너 사용법 익히기


[8/13]
1) 스프링 ContextLoaderListener 적용
=> build.gradle 파일에 spring-webmvc 의존 라이브러리 추가 
=> web.xml에  리스너 설정 변경, 컨텍스트 파라미터 추가 
=> kt.c.servlet.DispatcherServlet 클래스 변경함

2) 스프링 DispatcherServlet 적용
=> web.xml의 서블릿 정보 변경
=> 스프링의 DispatcherServlet이 사용할 빈 설정 파일을 추가(예: do-servlet.xml)
=> ContextLoaderListener가 관리하는 객체 중에서 페이지 컨트롤러는 DispatcherServlet으로 이관함.
=> MVC 관련 애노테이션을 처리하도록 작업자 등록.

3) 페이지 컨트롤러를 스프링 규칙에 맞춰서 변경
=> kt.c.control.Controller 인터페이스 구현할 필요가 없다. 제거
=> 요청 처리를 수행하는 메서드(Request Handler)는 스프링 규칙에 따라 만든다.
   . 메서드 이름은 마음대로, 파라미터는 규칙에 따라 마음대로, 리턴 타입도 규칙에 따라 마음대로 
   . 다만, 메서드 앞에 @RequestMapping을 선언한다. 

3) 요청 핸들러(요청이 들어 왔을 때 호출되는 메서드) 작성법
=> ModelAndView 리턴
=> String 리턴
=> Model 또는 Map 파라미터 사용

4) @RequestMapping 사용법
=> 클래스에 선언, 메서드에 선언 , 클래스와 메스드에 함께 선언
=> method 속성으로 GET, POST 구분하기

5) 요청 핸들러의 파라미터 다루는 방법
=> 파라미터 값으로 HttpSession 객체 받기
=> 파라미터 값으로 HttpServletRequest와 HttpServletResponse 받기
=> ServletContext 객체를 주입 받기
=> 요청 파라미터(웹 브라우저에게 넘겨주는 값) 값을 요청 핸들러의 파라미터 변수로 받기
	=> @RequestParam("요청파라미터이름") 타입 변수명
	=> 만약, 요청 파라미터 이름과 변수명이 같다면 애노테이션 생략 가능하다.
	=> 메서드의 파라미터 변수가 기본 타입(byte,short,int,long,float,double,boolean,char)인 경우,
	   요청 파라미터로 넘어 온 문자열 값을 자동 변환한다. 
=> 요청 파라미터의 값을 VO 객체에 바로 받을 수 있다.  
     
6) @SessionAttributes 애노테이션 사용
=> 세션에 보관될 객체의 이름을 지정한다.
=> Model에 해당 객체를 저장하는 순간 세션 보관함으로 옮겨짐.
  
7) @ModelAttribute("세션에 보관한 객체 이름")
=> 세션에 보관한 객체를 요청 핸들러의 파라미터로 받는다.  

8) 멀티파트 폼 데이터 처리
=> 빈 설정 파일에 멀티 파트 폼 데이터를 처리하는 객체를 활성화 한다.
=> 요청 핸들러에 MultipartFile 사용하기

9) Mybatis 적용
=> 의존 라이브러리 build.gradle에 추가
   compile 'org.mybatis:mybatis:3.2.7'
=> mybatis와 스프링을 연동하는 라이브러리 추가
   compile 'org.mybatis:mybatis-spring:1.2.2'
=> mybatis 설정 파일 작성 (kt/c/conf/mybatis-config.xml)
=> SQL Mapper 파일 작성 (kt/c/dao/BoardDAO.xml)
=> 스프링의 ContextLoaderListener 빈 설정 파일(application-context.xml)에 mybatis 객체 추가





























