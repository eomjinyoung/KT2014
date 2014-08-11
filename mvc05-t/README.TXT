[8/8]
1) Front Controller 디자인 패턴 적용(mvc02)
2) Dependency Injection 적용(mvc03)
3) Pooling 기법 (mvc03)
=> 객체 생성에 시간이 오래 걸리는 경우 미리 객체를 생성해 놓고 빌리는 방식으로 사용하는 것.
=> 디자인 패턴: Flyweight 패턴 

[8/9]
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
     
5) Mybatis 적용






























