package iloveyouboss;

public class CaesarCipher {

  public String solution(String s, int n) {
    // char 배열 만들기
    char[] chars = s.toCharArray();

    //문자 바꾸기
    for (int i = 0; i < chars.length; i++) {
      // 띄어쓰기는 그대로
      if (chars[i] == ' ') {
        continue;
      }
      // 대문자
      if (Character.isUpperCase(chars[i])) {
        chars[i] = (char) ((chars[i] - 'A' + n) % 26 + 'A');
      }
      // 소문자
      else if (Character.isLowerCase(chars[i])) {
        chars[i] = (char) ((chars[i] - 'a' + n) % 26 + 'a');
      }
    }

    // 문자열로 만들기
    StringBuilder sb = new StringBuilder();
    for (char c : chars) {
      sb.append(c);
    }
    return sb.toString();
  }
}