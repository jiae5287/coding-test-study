package programmers.withExplanation;

import java.util.Arrays;
import java.util.Collections;

public class FailureRate {

  /**
   *            도전 중 !!
   *
   *            << 프로그래머스 :: 실패율 >>
   *            https://school.programmers.co.kr/learn/courses/30/lessons/42889
   *
   *            - 문제 설명
   *            실패율 정의 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
   *            실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하라
   *
   *            - 제한 사항
   *            스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
   *            stages 의 길이는 1 이상 200,000 이하이다.
   *            stages 에는 1 이상 N + 1 이하의 자연수가 담겨있다.
   *            각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
   *            단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
   *            만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
   *            스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
   *
   *            - 도출 과정
   *
   *
   */

  // N 단계의 스테이지가 존재함
  public int[] solution(int N, int[] stages) {
    // 정답을 위한 배열
    int[] answer = new int[N];
    // 실패율을 계산해 담을 list
    Double[] failure = new Double[N + 1];
    // 정답을 도출하기 위해 실패율을 담을 list
    Double[] duplicatedFailure = new Double[N + 1];

    for (int i = 1; i < N + 1; i++) {

      // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어를 위한 변수
      double looser = 0.0d;
      // 스테이지에 도달한 플레이어를 위한 변수
      double challenger = 0.0d;

      // 사용자의 스테이지 확인
      for (int j = 0; j < stages.length; j++) {
        // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어 구하기
        if ( stages[j] == i ) { looser++; }
        // 스테이지에 도달한 플레이어 구하기
        if ( stages[j] >= i ) { challenger++; }
      }
      System.out.println();
      System.out.println(looser);
      System.out.println(challenger);
      System.out.println(looser / challenger);
      System.out.println();
      failure[i] = ( looser / challenger );
      // 복제
      duplicatedFailure[i] = failure[i];
    }

    Arrays.sort(duplicatedFailure, Collections.reverseOrder());


    return new int[1];
  }
}
