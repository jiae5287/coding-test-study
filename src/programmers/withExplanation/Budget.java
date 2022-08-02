package programmers.withExplanation;

import java.util.Arrays;

public class Budget {

  /**
   *        << 프로그래머스 :: 예산 >>
   *        https://school.programmers.co.kr/learn/courses/30/lessons/12982
   *
   *        - 문제 설명 :
   *        전체 예산 = budget, 부서 당 요구 금액 = d[]
   *        부서별로 신청한 금액이 들어있는 배열 d와 예산 budget 이 매개변수로 주어질 때,
   *        최대 몇 개의 부서에 물품을 지원할 수 있는지 return 하라.
   *
   *        - 제한 사항 :
   *        d는 부서별로 신청한 금액이 들어있는 배열이며, 길이(전체 부서의 개수)는 1 이상 100 이하입니다.
   *        d의 각 원소는 부서별로 신청한 금액을 나타내며, 부서별 신청 금액은 1 이상 100,000 이하의 자연수입니다.
   *        budget 은 예산을 나타내며, 1 이상 10,000,000 이하의 자연수입니다.
   *
   *        - 푸는 방식 :
   *        0.0 최대한 많은 팀들을 지원해주려면 예산이 작은 팀부터 정렬해야 한다.
   *        0.1 예산이 중구난방이면 더 많은 팀을 지원할 수 있는데도 못 하는 경우가 생길 수 있다.
   *        1.  d[]를 오름차순으로 정렬
   *        2.  budget 에서 d[]의 원소를 하나씩 빼준다.
   *        3.  뺀 값이 0보다 작다면  answer 값 return.
   *        4.  뺀 값이 0이거나 0보다 크다면 answer++.
   *
   */

  public int solution(int[] d, int budget) {
    // 준비
    Arrays.sort(d);
    int answer = 0;

    // 풀이
    for (int amount : d) {
      budget = budget - amount;
      if (budget < 0) break;
      answer++;
    }

    //결과
    return answer;
  }
}
