package programmers.withExplanation;

/**
 *       <<프로그래머스 :: 신규 아이디 추천 >>
 *       https://school.programmers.co.kr/learn/courses/30/lessons/72410
 *
 *       - 문제 설명
 *       새로 가입하는 유저들이 카카오 아이디 규칙에 맞지 않는 아이디를 입력했을 때,
 *       입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천해주는 프로그램을 개발하라.
 *
 *       (1단계) new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
 *       (2단계) new_id 에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
 *       (3단계) new_id 에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
 *       (4단계) new_id 에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
 *       (5단계) new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
 *       (6단계) new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
 *              만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
 *       (7단계) new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
 *
 *
 *
 *       - 도출 과정
 *       단계별로 메서드를 만듭니다.
 *       정규식은 익숙하지 않아 사용하지 않았습니다.
 *
 *       1단계 : toLowerCase() 사용
 *       2단계 : StringBuilder 이용해서 메모리 사용 줄이기, char 범위 부등호 사용
 *       3단계 : contains() 메서드를 사용해 ".."이 존재하지 않을 때까지 "."로 replace()하기
 *              ".."을 '.'로 교체해도 '.'과 '.'이 만나 다시 ".."을 이룰 수 있기 때문에
 *              ".."이 없어질 때까지 '.'으로 변경.
 *       4단계 : "isEmpty() => value.length == 0"을 사용하여 length()가 0이 아닌 경우,
 *              String 맨앞과 맨뒤에 '.'이 존재하는지 확인하고 있으면 subString()을 이용해 제거.
 *       5단계 : "isEmpty() => value.length == 0"을 사용하여, 만약 length()가 0인 경우,
 *              a를 return.
 *              isBlank()를 사용하지 않은 이유는 아이디에 공백이 존재하지 않기 때문.
 *       6단계 : new_id의 길이가 16자 이상이면, subString()을 이용해
 *              첫 15개의 문자를 제외한 나머지 문자들을 모두 제거.
 *              제거 후, '.'가 new_id의 끝에 위치한다면 '.' 제거.
 *       7단계 : 아이디가 3글자 미만이면 마지막 글자를 반복하여 글자수를 3글자 이상으로 만듦.
 *              StringBuilder 와 charAt()을 사용
 *
 */
class NewId {

  private String L1(String new_id) {
    return new_id.toLowerCase();
  }

  private String L2(String new_id) {
    char[] chars = new_id.toCharArray();
    StringBuilder stringBuilder = new StringBuilder();
    for (char c : chars) {
      if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
        stringBuilder.append(c);
      }
    }
    return stringBuilder.toString();
  }

  private String L3(String new_id) {
    while (new_id.contains("..")) {
      new_id = new_id.replace("..", ".");
    }
    return new_id;
  }

  private String L4(String new_id) {
    if (!new_id.isEmpty()) {
      if (new_id.charAt(0) == '.') {
        new_id = new_id.substring(1, new_id.length());
      }
    }
    if (!new_id.isEmpty()) {
      if (new_id.charAt(new_id.length() - 1) == '.') {
        new_id = new_id.substring(0, new_id.length() - 1);
      }
    }
    return new_id;
  }

  private String L5(String new_id) {
    if (new_id.isEmpty()) {
      return "a";
    }
    return new_id;
  }

  private String L6(String new_id) {
    if (new_id.length() >= 16) {
      new_id = new_id.substring(0, 15);
      if (new_id.charAt(new_id.length() - 1) == '.') {
        return new_id.substring(0, new_id.length() - 1);
      }
    }
    return new_id;
  }

  private String L7(String new_id) {
    StringBuilder stringBuilder = new StringBuilder(new_id);
    if (stringBuilder.length() < 3) {
      char lastChar = stringBuilder.charAt(stringBuilder.length() - 1);
      while (stringBuilder.length() < 3) {
        stringBuilder.append(lastChar);
      }
    }
    return stringBuilder.toString();
  }

  public String solution(String new_id) {
    new_id = L1(new_id);
    new_id = L2(new_id);
    new_id = L3(new_id);
    new_id = L4(new_id);
    new_id = L5(new_id);
    new_id = L6(new_id);
    new_id = L7(new_id);

    return new_id;
  }
}
