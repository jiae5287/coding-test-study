package iloveyouboss;

public class StrangeString {

  public String solution(String s) {
    char[] chars = s.toCharArray();
    int idx = 0;

    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == ' ') {
        idx = 0;
      } else {
        idx++;
      }

      if (idx % 2 == 0) {
        Character.toUpperCase(chars[i]);
      } else if (idx % 2 != 0) {
        Character.toLowerCase(chars[i]);
      }
    }

    return String.valueOf(chars);
  }
}
