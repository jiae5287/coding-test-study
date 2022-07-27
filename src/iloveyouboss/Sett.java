package iloveyouboss;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Sett {
  public int[] solution(int []arr) {
    Set<Integer> numberSet = new HashSet<>();
    for(int num : arr) {
      numberSet.add(num);
    }
    return numberSet.stream().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
  }
}
