package programmers;

import java.util.Set;
import java.util.HashSet;

class Solution3 {
  public int[] solution(int[] numbers) {

    Set<Integer> answerSet = new HashSet<>();

    for (int i = 0; i < numbers.length; i++) {
      for (int j = (i + 1); j < numbers.length; j++) {
        answerSet.add(numbers[i] + numbers[j]);
      }
    }
    return answerSet.stream().sorted().mapToInt(Integer::intValue).toArray();
  }
}
