package programmers.withExplanation;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class FailureRate {

  /**
   * << 프로그래머스 :: 실패율 >>
   * 도전 중!
   * https://school.programmers.co.kr/learn/courses/30/lessons/42889ges
   */

  // N 단계의 stage 가 존재함
  public int[] solution(int N, int[] stages) {
    int[] answer = new int[stages.length];
    SortedMap<Float, Integer> sortedMap = new TreeMap<>(new Comparator<Float>() {
      @Override
      public int compare(Float o1, Float o2) {
        return o2.compareTo(o1);
      }
    });

    // 스테이지
    for (int i = 1; i <= N; i++) {

      int looser = 0;
      int challenger = 0;

      // 사용자의 스테이지 확인
      for (int j = 0; j < stages.length; j++) {
        // 분자 :: 실패한 사람 구하기
        if (stages[j] == i) {
          looser++;
        }

        // 분모 :: 도전한 사람 구하기
        if (stages[j] >= i) {
          challenger++;
        }
      }

      sortedMap.put((float) (looser / challenger), i);
    }

    return sortedMap.values().stream().mapToInt(value -> value.intValue()).toArray();
  }
}
