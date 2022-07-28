package programmers;

import java.util.Arrays;

public class NumDescending {
  public long solution(long n) {
    String numStr = n + "";
    char[] numChars = numStr.toCharArray();

    Arrays.sort(numChars);

    StringBuilder sb = new StringBuilder();
    for (int i = numChars.length - 1; i >= 0; i--) {
      sb.append(numChars[i]);
    }

    return Long.parseLong(sb.toString());
  }
}