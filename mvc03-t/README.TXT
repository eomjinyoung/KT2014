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
5) Mybatis 적용






























