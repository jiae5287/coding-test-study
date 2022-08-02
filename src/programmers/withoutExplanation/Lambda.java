package programmers.withoutExplanation;

public class Lambda {

  public static void main(String[] args) {
    /**
     * 기존의 자바에서 함수형 프로그래밍 개념 방법
     * 길게 늘어진 익명함수.
     * 가독성이 많이 떨어짐.
     */
    System.out.println(new MyLambdaFunction() {
      @Override
      public int max(int a, int b) {
        return a > b ? a : b;
      }
    }.max(3, 5));

    /**
     * (( 람다식))
     * 함수를 하나의 식(하나의 변수)으로 표현한다.
     * 메소드의 이름이 필요없기 때문에 익명 함수이다.
     * 모두 일급객체이다.
     */
    MyLambdaFunction myLambdaFunction = (int a, int b) -> a > b ? a : b;
    System.out.println(myLambdaFunction.max(3,5));
  }
}
