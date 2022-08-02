package programmers.withExplanation;

import java.util.HashMap;
import java.util.Map;

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
   *            0. stage 와 실패율이 항상 같이 붙어다녀야 하므로 Map 을 사용.
   *            1. 각 stage 별 실패율을 구함.
   *            2. Map 의 Key 는 stage, value 는 실패율로 구성함.
   *            3. 실패율이 가장 높은 스테이지부터 answer[]에 넣어서 반환.
   *
   *            - ** 풀지 못 한 부분 **
   *            실패율이 가장 높은 스테이지부터 answer[]에 넣어서 반환.
   *
   *            - ** 풀지 못 한 이유는? **
   *            (0) Map 의 value 을 기준으로 내림차순 해야 하는데, 어떤 방법을 사용해야 할지 모르겠어서.
   *
   *            (1) MaxValue 와 MaxKey 변수 2개를 사용해서 정렬해주면 된다.
   *                MaxValue 를 찾으면 MaxKey 의 값도 저장해뒀다가 answer[]에 넣어준다.
   *
   *            (2) Map 은 for 문을 어떻게 돌 수 있는지 고민.
   *                KeySet 를 이용해 foreach 하면 된다.
   *
   *
   *
   */

  public int[] solution(int N, int[] stages){
    int[] answer = new int[N];
    Map<Integer, Double> map = new HashMap<>();

    for(int i = 1; i <= N; i++) {
      int stage = i;
      int noClearPlayer = 0;
      int currentStagePlayer = 0;

      for (int j = 0; j < stages.length; j++) {
        int player = stages[j];

        if (stage == player) {
          noClearPlayer++;
        }

        if (stage <= player) {
          currentStagePlayer++;
        }
      }

      double failureRage = 0;
      if (noClearPlayer != 0 && currentStagePlayer != 0) {
        failureRage = (double) noClearPlayer / (double) currentStagePlayer;
      }

      map.put(stage, failureRage);
    }

    for (int i = 0; i < N; i++) {
      double maxValue = -1;
      int maxKey = 0;
      for (Integer key : map.keySet()) {
        if (maxValue < map.get(key)) {
          maxValue = map.get(key);
          maxKey = key;
        }
      }
      answer[i] = maxKey;
      map.remove(maxKey);
    }
    return answer;
  }
}
