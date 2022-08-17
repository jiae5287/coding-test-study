package programmers.withExplanation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *        <프로그래머스 : 전화번호 목록>
 *        https://school.programmers.co.kr/learn/courses/30/lessons/42577
 *
 *        - 문제 설명 :
 *        전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 한다.
 *        전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이 전화번호의 접두사이다.
 *        # 구조대 : 119
 *        # 지영석 : 11 9552 4421
 *        전화번호부에 적힌 전화번호를 담은 배열 phone_book이 매개변수일 때,
 *        어떤 번호가 다른 번호의 접두어인 경우 false : 그렇지 않을 때 true를 return 하도록 하라.
 *
 *        - 제한 사항 :
 *        phone_book의 길이는 1 이상 1,000,000 이하입니다.
 *        각 전화번호의 길이는 1 이상 20 이하입니다.
 *        같은 전화번호가 중복해서 들어있지 않습니다.
 *
 *        - 내 풀이 : array 사용
 *        1. phone_book[]을 복사하여 phone_book_copy[]를 만듦.
 *        2. 이중 for문을 사용.
 *        - 같은 인덱스면 continue;
 *        - 현재 값의 길이가 비교해야 할 값 보다 길면 continue;
 *        - startWith()를 사용하여 접두어인 경우 answer에 false를 넣는다.
 *        => 정확성 테스트는 통과했으나, 효율성 테스트는 실패!
 *
 *        - 다른 사람 풀이 1 : array 사용
 *        1.  배열을 사전순 오름차순으로 정렬한다.
 *        1.1 이렇게 하면 phone_book[i]가 phone_book[i + 1]의 접두어이면서 phone_book[i + 2]의 접두어일 수는 있어도,
 *            phone_book[i + 1]나 phone_book[i + 2]가 phone_book[i]의 접두어일 순 없다.
 *        2.  이중 for문을 사용하여 앞값이 뒷값의 접두어인지 확인.
 *        => 정확성 테스트는 통과했으나, 효율성 테스트는 실패!
 *
 *        - 정답 : hashMap 사용
 *        "같은 전화번호는 없다"라는 문장에서 중복을 허용하지 않는다는 사실을 알 수 있다.
 *        중복을 제거하는 문제는 아니므로 Set을 사용하는 것을 옳지 않고, Map의 Key로 전화번호를 사용할 수 있겠다는 생각을 한다.
 *        1. 전화번호 문자열을 key로 하는 HashMap 생성
 *        2. 반복문으로 각 전화번호의 접두사가 keySet에 있는지 확인.
 *        3. 각 전화번호의 접두사는 (문자열 길이 - 1)개 만큼 존재하며, 이 접두사를 하나씩 확인해야 함.
 *        4. 전화번호에서 추출해낸 접두사가 HashMap에 존재하면 false 반환
 *        5. 아무 접두사도 HashMap에 존재하지 않으면 if문에 걸리지 않고 반복문이 끝났으면 true 반환.
 *
 */
public class PhoneBook {

  // 내 풀이 : array 사용
  public boolean solution1(String[] phone_book) {

    boolean answer = true;
    String[] phone_book_copy = phone_book.clone();

    for (int i = 0; i < phone_book.length; i++) {
      for (int j = 0; j < phone_book_copy.length; j++) {
        if (i == j) continue;
        if (phone_book[i].length() > phone_book_copy[j].length()) continue;
        if (phone_book_copy[j].startsWith(phone_book[i])) answer = false;
      }
    }
    return answer;
  }


  // 다른 사람의 풀이 1 : array 사용
  public boolean solution2(String[] phone_book) {

    boolean answer = true;
    Arrays.sort(phone_book);

    for (int i = 0; i < phone_book.length; i++) {
      for (int j = i + 1; j < phone_book.length; j++) {
        if (phone_book[j].startsWith(phone_book[i])) {
          answer = false;
          break;
        }
      }
    }
    return answer;
  }

  // 정답 : hashMap 사용
  public boolean solution3(String[] phone_book) {
    boolean answer = true;
    Map<String, Integer> map = new HashMap<>();

    // phone_book[]를 KeySet으로 가지는 Map 만들기
    for (String digits : phone_book) {
      map.put(digits, 0);
    }

    // phone_book[]의 원소 하나씩 뽑아서, 해당 원소의 접두사 경우의 수를 모두 확인함.
    for (String digits : phone_book) {
      for (int i = 1; i < digits.length(); i++) {
        String prefix = digits.substring(0, i);
        if(map.containsKey(prefix)) {
          answer = false;
          break;
        }
      }
    }

    return answer;
  }
}
