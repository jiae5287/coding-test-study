package programmers.withoutExplanation;

import java.util.Arrays;

public class CollectionStream {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4};
    System.out.println(solution(arr));
  }

  public static double solution(int[] arr) {
    return Arrays.stream(arr).average().orElse(0);
  }
}
