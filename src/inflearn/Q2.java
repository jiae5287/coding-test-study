package inflearn;

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
