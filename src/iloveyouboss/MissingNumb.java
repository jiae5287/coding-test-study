package iloveyouboss;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MissingNumb {

  public int solution(int[] numbers) {
    Arrays.sort(numbers);
    Map<Integer, Integer> missingNum = new HashMap<>();
    for (int i = 0; i < 10; i++) {
      missingNum.put(i, i);
    }
    for (int i = 0; i < numbers.length; i++) {
      missingNum.put(numbers[i], 0);
    }
    int answer = 0;
    for (int i = 0; i < 10; i++) {
      answer += missingNum.get(i);
    }
    return answer;
  }

  public int solution2(int[] numbers) {
    int sum = 45;
    for (int number : numbers) {
      sum -= number;
    }
    return sum;
  }

}
