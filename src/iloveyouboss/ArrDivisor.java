package iloveyouboss;

import java.util.ArrayList;
import java.util.List;

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
    return answer.stream().sorted().mapToInt(value -> (value.intValue())).toArray();
  }
}
