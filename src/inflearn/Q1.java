package inflearn;

import java.util.Scanner;

/**
 *    문제1 : 문자 찾기
 *    한 개의 문자열을 입력받고, 특정 문자를 입력받아
 *    해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
 *    !! 대소문자 구분 없습니다. !!
 *
 *    풀이 :
 *    받은 문자열과 문자를 대문자로 통일한다.
 *    문자열을 배열로 바꾸고, 문자와 배열의 원소를 하나씩 비교한다.
 *
 *
 *    Character와 관련된 함수를 사용하고 싶다면 wrapper class 이용하기.
 *    char를 입력받을 땐 scanner.next().charAt(0);
 *
 *
 */
public class Q1 {

  public int solution(String str, char t) {
    int answer = 0;
    str = str.toUpperCase();
    t = Character.toUpperCase(t);

   for (char c : str.toCharArray()) {
     if (c == t) answer++;
   }
    return answer;
  }

  public static void main(String[] args) {
    // 설정
    Q1 q1 = new Q1();
    Scanner in = new Scanner(System.in);

    // 입력
    String input1 = in.next();
    char input2 = in.next().charAt(0);

    // 출력
    System.out.println(q1.solution(input1, input2));
  }
}
