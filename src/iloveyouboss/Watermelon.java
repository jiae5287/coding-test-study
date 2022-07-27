package iloveyouboss;

class Watermelon {
  public String solution(int n) {
    char[] chars = new char[n];
    for (int i = 1; i <= n; i++) {
      if (i % 2 != 0) {
        chars[i - 1] = '수';
      } else {
        chars[i -1] = '박';
      }
    }

    StringBuilder stringBuilder = new StringBuilder();

    for (char c : chars) {
      stringBuilder.append(c);
    }

    return stringBuilder.toString();
  }
}
