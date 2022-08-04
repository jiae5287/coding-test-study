package programmers.withExplanation;

import java.util.ArrayList;
import java.util.List;

/**
 *        <<프로그래머스 :: 비밀지도>>
 *        https://school.programmers.co.kr/learn/courses/30/lessons/17681
 *
 *        - 문제 설명
 *        비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다.
 *        그런데, 이 비밀지도는 위치를 확인하기 위해서는 암호를 해독해야 한다.
 *        지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 "공백"(" ") 또는 "벽"("#")으로 이루어져 있다.
 *        전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다.
 *        지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다.
 *        지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
 *        "지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
 *        암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
 *        비상금을 손에 넣을 수 있도록, 비밀지도의 암호를 해독하라.
 *
 *        - 나의 도출 과정
 *        1. for문을 돌면서 arr1의 원소를 하나씩 2진수으로 변경하기
 *        2. for문을 돌면서 arr2의 원소를 하나씩 2진수으로 변경하기
 *        3. arr1의 원소와 arr2의 원소를 비교하면서 String값으로 변경해서 return.
 *
 *        - 수정할 부분
 *        else if가 아니라 "비트논리연산자"를 사용하면 쉽게 풀리는 문제!
 *        복잡하게 모든 원소들을 2진수로 변경해서 비교하는 것이 아니라,
 *        비트논리연산을 이용해 arr1과 arr2의 원소끼리의 | 결과값을 찾고,
 *        그 값을 2진수로 변경하여 String값을 찾는 것이 훨씬 깔끔하다.
 *
 */

public class SecretMap {

  // 나의 풀이
  public String[] solution1(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];

    // for문을 돌면서 arr1의 원소를 하나씩 2진법으로 변경하기.
    List<int[]> binaryArr1 = new ArrayList<>();
    for (int i = 0; i < arr1.length; i++) {
      binaryArr1.add(getBinaryNumber(n, arr1[i]));
    }

    // for문을 돌면서 arr2의 원소를 하나씩 2진법으로 변경하기.
    List<int[]> binaryArr2 = new ArrayList<>();
    for (int i = 0; i < arr2.length; i++) {
      binaryArr1.add(getBinaryNumber(n, arr2[i]));
    }

    // arr1의 원소와 arr2의 원소를 비교하여 String으로 변경하기.
    return changeNumberToString(n, binaryArr1, binaryArr2);
  }

  // 이상적인 풀이 1
  public String[] solution2(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];

    for (int i = 0; i < n; i++) {
      StringBuilder sb = new StringBuilder();
      int number = arr1[i] | arr2[i];
      int[] binaryNumber = getBinaryNumber(n, number);
      for (int j = n - 1; j >= 0; j--) {
        if (binaryNumber[j] == 1) sb.append('#');
        else sb.append(' ');
      }
      answer[i] = sb.toString();
    }

    return answer;
  }

  // 이상적인 풀이 2
  // Integer.toBinaryString()을 알지 못 함.
  // String.format()을 활용하지 못 함.
  public String[] solution3(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];
    for (int i = 0; i < n; i++) {
      String s = Integer.toBinaryString(arr1[i] | arr2[i]);
      s = String.format("%" + n + "s", s);
      s.replace('1', '#');
      s.replace('0', ' ');
      answer[i] = s;
    }

    return answer;
  }




  // 이진법 구할 때 쓰는 함수.
  private int[] getBinaryNumber(int n, int number) {
    int[] binaryNumber = new int[n];
    int i = 0;
    while (number > 0) {
      binaryNumber[i] = number % 2;
      number = number / 2;
      i++;
    }
    return binaryNumber;
  }

  // solution1()에서만 쓰는 메서드, arr1 원소의 이진수와 arr2 원소의 이진수를 비교하여 string[]으로 변경해줌.
  private String[] changeNumberToString(int n, List<int[]> binaryArr1, List<int[]> binaryArr2) {
    String[] binaryString = new String[n];

    for (int i = n - 1; i >= 0; i--) {
      StringBuilder sb = new StringBuilder();
      int[] arr1BinaryNumber = binaryArr1.get(i);
      int[] arr2BinaryNumber = binaryArr2.get(i);

      for (int j = 0; j < n; j++) {
        if (arr1BinaryNumber[j] == 1 || arr2BinaryNumber[j] == 1) sb.append('#');
        else if (arr1BinaryNumber[j] == 0 && arr2BinaryNumber[j] == 0) sb.append(' ');
      }

      binaryString[i] = sb.toString();
    }
    return binaryString;
  }
}
