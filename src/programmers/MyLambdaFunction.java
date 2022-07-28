package programmers;

@FunctionalInterface
public interface MyLambdaFunction {

  /**
   * https://mangkyu.tistory.com/113
   *
   * 1. collection 은 Stream 을 사용할 수 있다.
   * 2. Stream 은 매개변수와 return 으로 함수형 인터페이스를 사용한다.
   *
   * ((함수형 프로그래밍))
   * 거의 모든 것을 순수 함수로 나누어 문제를 해결하는 기법
   * 가독성을 높이고 유지보수를 용이하게 해준다.
   * 함수를 1급 객체로 취급하기 때문에 파라미터로 넘기거나 반환값으로 사용할 수 있다.
   *
   * ((함수형 인터페이스))
   * @FunctionalInterface
   * 함수를 1급 객체처럼 다룰 수 있게 해주는 어노테이션
   * 인터페이스에 선언하여 단 하나의 추상 메소드만을 갖도록 제한하는 역할
   * 사용하는 이유는 Java 의 람다식이 함수형 인터페이스를 반환하기 때문이다.
   */

  // 람다식으로 사용할 메서드
  int max(int a, int b);
}
