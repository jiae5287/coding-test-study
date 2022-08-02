package programmers.withoutExplanation;

class Py {
  boolean solution(String s) {
    char[] chars = s.toCharArray();
    int countp = 0;
    int county = 0;
    boolean answer = true;

    for(char c : chars) {
      if (c == 'p' || c == 'P') {
        countp++;
      } else if (c == 'y' || c == 'Y') {
        county++;
      }
    }

    if (countp != county) {
      return false;
    }

    return answer;
  }
}
