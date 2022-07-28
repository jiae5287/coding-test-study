package programmers.withExplanation;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArr {

  /**
   *        << 프로그래머스 :: 문자열 내 마음대로 정렬하기 >>
   *        https://school.programmers.co.kr/learn/courses/30/lessons/12915
   *
   *        - 문제 설명
   *        1. 문자열로 구성된 리스트 strings와, 정수 n이 주어진다.
   *        2. 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬한다.
   *        3. 인덱스 n번째 글자가 동일하다면, 사전 순으로 정렬한다.
   *
   *        - 제한 조건
   *        strings는 길이 1 이상, 50이하인 배열이다.
   *        strings의 원소는 소문자 알파벳으로 이루어져 있다.
   *        strings의 원소는 길이 1 이상, 00이하인 문자열이다.
   *        모든 strings의 원소의 길이는 n보다 크다.
   *        인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치한다.
   *
   *
   *       - 도출 과정
   *       * 인덱스 n 번째로 정렬한 뒤, 사전순으로 한 번 더 정렬해야 한다.
   *       1."인덱스 n번째 글자 + 원래 단어" 의 형태로 strings 의 원소들을 변경한다.
   *       2. Arrays.sort()를 사용하여 strings 를 정렬한다.
   *       3. 앞에 붙어있는 앞에 있는 인덱스 n번째 글자들을 제거하고 값을 리턴한다.
   *
   */

  // 방법1
  public String[] solution1(String[] strings, int n) {
    for (int i = 0; i < strings.length; i++) {
      strings[i] = strings[i].charAt(n) + strings[i];
    }

    Arrays.sort(strings);

    for (int i = 0; i < strings.length; i++) {
      strings[i] = strings[i].substring(1, strings[i].length());
    }

    return strings;
  }

  // 방법2 :: 좀 더 자바스러운 방식으로, comparator 를 사용한다.
  public String[] solution2(String[] strings, int n) {
    Arrays.sort(strings, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        if (s1.charAt(n) > s2.charAt(n)) return 1;
        else if (s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
        else return -1;
      }
    });
    return strings;
  }
}
