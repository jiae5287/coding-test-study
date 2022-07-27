package iloveyouboss;

import java.util.Arrays;

public class CharsAscending {
  public String solution(String s) {
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    StringBuilder sb = new StringBuilder();
    for (int i = chars.length - 1; i >= 0; i--) {
      sb.append(chars[i]);
    }
    return sb.toString();
  }
}
