package programmers.withoutExplanation;

public class OneTowFour {
  public String solution(int n) {
    // 10진법을 3진법으로 변경하는 것.
    // 그러나 124나라에는 0이 존재하지 않음.
    // 따라서 3으로 나눴을 때 딱 떨어지는 수가 나오면, 윗자리수 값을 1개 빼주고, 현재값을 3으로 변경해야 한다.
    // 그러나 124나라에는 3이 없으므로 3 대신 4로 변경한다.

    // 예시
    // 10(10)는 101(3)이다.
    // 그러나 124나라에는 0이 존재하지 않으므로, 윗자리수 값을 1개 빼서 현재자리값을 31으로 만들어준다.
    // 따라서 값은 31이다.
    // 그러나 124나라에는 3이 존재하지 않으므로, 3을 4로 대체한다.
    // 따라서 값은 41이다.

    StringBuilder answer = new StringBuilder();
    int r = 0;
    while (n > 0) {
      r = n % 3;
      n = n / 3;
      if (r == 0) {
        n--;
        r = 4;
      }
      answer.insert(0, r);
    }
    return answer.toString();
  }
}
