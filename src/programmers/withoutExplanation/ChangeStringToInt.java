package programmers.withoutExplanation;

import java.util.*;
// 부호가 있는 경우
// 부호가 없는 경우
// 자리수에 맞게 정수로 바꿔주기
public class ChangeStringToInt {
    public boolean solution(String s) {
      if (s.length() == 4 || s.length() == 6) return s.matches("(^[0-9]*$)");
      return false;
    }
}
