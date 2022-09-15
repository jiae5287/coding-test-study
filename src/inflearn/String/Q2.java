package inflearn.String;

/**
 *  문제 설명 :
 *  대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
 *
 *  입력 :
 *  첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
 *  문자열은 영어 알파벳으로만 구성되어 있습니다.
 *
 *  출력 :
 *  첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
 *
 *  풀이 :
 *  string 값을 받아서 배열로 만들고
 *  배열의 원소들이 대문자면 소문자로 바꾸고, 소문자면 대문자로 바꿈
 */

import java.util.Scanner;

public class Q2 {

  public String solution(String str) {
    StringBuilder sb = new StringBuilder();
    for (char c : str.toCharArray()) {
      if (Character.isLowerCase(c)) sb.append(Character.toUpperCase(c));
      else if (Character.isUpperCase(c)) sb.append(Character.toLowerCase(c));
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Q2 q2 = new Q2();
    Scanner scanner = new Scanner(System.in);
    String input = scanner.next();
    System.out.println(q2.solution(input));
  }
}
