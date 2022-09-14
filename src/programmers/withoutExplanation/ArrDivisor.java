package programmers.withoutExplanation;

import java.util.ArrayList;
import java.util.List;

/**
 *    <프로그래머스 :: 나누어 떨어지는 숫자 배열>
 *
 *    문제 설명 :
 *    array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수를 작성해주세요.
 *    divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
 *
 *    제한 사항 :
 *    arr은 자연수를 담은 배열입니다.
 *    정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
 *    divisor는 자연수입니다.
 *    array는 길이 1 이상인 배열입니다.
 *
 *    풀이 :
 *    divisor로 나눠어 떨어지는 경우와 아닌 경우를 나눠서 생각해야 한다.
 *
 *    case 1 : divisor로 나눠어 떨어지는 경우
 *    배열의 크기를 미리 알 수 없기 때문에 Collection의 List를 사용한다.
 *    만약 나눠지는 element라면 list에 넣어준다.
 *
 *    case 2 : divisor로 나눠어 떨어지는 않는 경우
 *    case1을 실행한 뒤, list의 size가 0인 경우 -1을 return한다.
 *
 *    return 하지 않았다면,
 *    list를 sorted하여 오름차순으로 정렬하고 배열로 변경하여 값을 return한다.
 *
 */
public class ArrDivisor {

  public int[] solution(int[] arr, int divisor) {
    // 기본 셋팅
    List<Integer> answer = new ArrayList<Integer>();

    // 실행
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % divisor == 0) {
        answer.add(arr[i]);
      }
    }

    // 값이 없는 경우
    if (answer.size() == 0) {
      return new int[]{-1};
    }

    // 값이 있는 경우
    // stream 생성 => 오름차순으로 정렬(중간 연산) => Integer를 int로 변경 => List를 Array로 변환(최종 연산)
    return answer.stream().sorted().mapToInt(value -> (value.intValue())).toArray();
  }
}
