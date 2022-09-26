package codility;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {

  public int solution(int[] A) {
    int answer = 0;
    Map<Integer, Integer> map = new HashMap();
    for (int num : A) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (int key : map.keySet()) {
      if (map.get(key) % 2 != 0) {
        answer = key;
        break;
      }
    }
    return answer;
  }
}
