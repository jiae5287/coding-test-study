package iloveyouboss;

import java.util.ArrayList;
import java.util.List;

public class Trit {
  public int solution(int n) {
    List<Integer> arr = new ArrayList<Integer>();
    // 3진법으로 만들기
    while (n / 3 != 0) {
      arr.add(n % 3);
      n = n / 3;
    }

    if(arr.iterator().hasNext()) {
      System.out.println(arr.iterator().next());
    }
    // 수 뒤집기
    // 뒤집은 수를 10진법으로 표현하기
    int answer = 0;
    return answer;
  }
}
