package programmers.withExplanation;

public class MidStr {

  /**
   *          <<프로그래머스 :: 가운데 글자 가져오기>>
   *          https://school.programmers.co.kr/learn/courses/30/lessons/12903
   *
   *
   *          - 문제 설명
   *          단어 s의 가운데 글자를 반환하는 함수를 만들어라
   *          단어의 길이가 짝수라면 가운데 두글자를 반환한다
   *
   *          - 도출 과정
   *          1. s.length()를 이용하여 가운데 index 값을 구한다 . => midIdx
   *          2. 짝수인 경우와 홀수인 경우를 나눠서 생각한다.
   *          3. s.length() % 2 == 0 는 짝수
   *          4. s.length() % 2 != 0 는 홀수
   *          5. s.charAt을 이용해 값을 추출한다.
   *
   *          - 배운 점
   *          charAt을 이용하여 문제를 풀었으나, 시간복잡도가 과하게 크게 나왔다.
   *          substring()을 이용하여 해당 문제를 푸는 것이 여러모로 유용하다는 것을 깨달았다.
   */
    public String solution(String s) {
      // 가운데 idx 구하기
      int midIdx = s.length() / 2;

      if ( s.length() % 2 == 0 ) {// 짝수
        return  s.substring(midIdx - 1, midIdx);
      } else {// 홀수
        return s.substring(midIdx);
      }
    }
}
