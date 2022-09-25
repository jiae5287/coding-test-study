package programmers.withExplanation;


import java.util.Arrays;

/**
 *    문제 설명 ::
 *    문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다.
 *    str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수,
 *    solution을 완성하세요.
 *
 *    예시 ::
 *    예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고,
 *    "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
 *
 *    제한 조건 ::
 *    s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
 *
 *    문제 풀이 ::
 *    1. String의 split을 이용해서 array 만들기.
 *    2. 해당 array를 Integer type으로 변경 및 정렬하기. <= stream 사용.
 *    2. "mapToInt(Integer::parseInt)" <= IntStream
 *    3. 최솟값 최댓값 빼오기.
 */
public class MaxMinNum {

  public static void main(String[] args) {
    MaxMinNum mmn = new MaxMinNum();

    System.out.println(mmn.solution("-1 -2 -3 -4"));
  }

  public String solution(String s) {
    String[] strings = s.split(" ");
    int[] nums = Arrays.stream(strings)
        .mapToInt(Integer::parseInt)
        .sorted()
        .toArray();

    return nums[0] + " " + nums[nums.length - 1];
  }
}
