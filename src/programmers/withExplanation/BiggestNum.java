package programmers.withExplanation;

import java.util.Arrays;
import java.util.Comparator;

/**
 *     프로그래머스 :: 가장 큰 수
 *     https://school.programmers.co.kr/learn/courses/30/lessons/42746
 *
 *     - 문제 설명 :
 *     0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 *     예를 들어, 주어진 정수가 [6, 10, 2]라면, [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고,
 *     이중 가장 큰 수는 6210입니다.
 *     0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
 *     순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 *
 *     - 제한 사항 :
 *     numbers의 길이는 1 이상 100,000 이하입니다.
 *     numbers의 원소는 0 이상 1,000 이하입니다.
 *     정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 *
 *     - 풀이 방식 :
 *     방법1)
 *     처음에는 모든 경우의 수를 만들어서 ArrayList에 넣고 값을 내림차순으로 정렬하여 가장 앞의 값을 return하려 했다.
 *     그러나 numbers의 길이는 1 이상 100,000 이하라는 제한 사항을 보고 올바른 방식이 아니라고 생각했다.
 *
 *     방법2)
 *     방법을 바꿔 numbers를 사전식 내림차순으로 정렬한 후 그 순서대로 원소들을 더하면 가장 큰 수가 나올 것이라고 생각했습니다.
 *     따라서, numbers를 int[]에서 String[]로 변경하고, Array.sort와 Comparator.reserveOrder()를 이용하여 정렬했습니다.
 *     정렬한 원소들을 하나씩 꺼내 StringBuilder로 합하였고 답을 반환했습니다.
 *     그러나 2번째 예에서 3과 30이 "330"이 아닌 "303"이 됐습니다.
 *
 *     방법3)
 *     올바른 정렬을 위해서는 직접 정렬식을 세우는 수 밖에 없었습니다.
 *     따라서 comparator를 사용하여 문자열을 붙여서 비교한 후 내림차순으로 정렬했습니다.
 *     정렬한 원소들을 하나씩 꺼내 StringBuilder로 합하였고 답을 반환했습니다.
 *
 *     추가)
 *     방법3을 사용하여 문제를 풀었으나 테스트 케이스 11을 통과하지 못 했습니다.
 *     찾아보니 "0000"인 값을 그대로 반환해서 그런 것이었습니다.
 *     따라서 가장 앞자리 수가 "0"인 경우, 모두 0을 리턴하도록 if문을 추가했습니다.
 *
 *     시간복잡도 계산 : o(n^2)?
 *
 */
public class BiggestNum {
  public String solution(int[] numbers) {

    // 정렬하기 위해 int => String으로 변환
    String[] stringNums = new String[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      stringNums[i] = String.valueOf(numbers[i]);
    }

    // 사전식 내림차순으로 정렬, 숫자 자체가 커야하므로.
    Arrays.sort(stringNums, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return (o2 + o1).compareTo(o1 + o2);
      }
    });

    // 정답 만들기, 새로운 변수를 계속 만들지 않기 위해 StringBuilder 사용.
    StringBuilder answer = new StringBuilder();
    for (String str : stringNums) {
      answer.append(str);
    }

    // test case 11을 위한 조건 : "0000"인 경우, 어떻게 답을 해결해야 할까?
    if (answer.toString().charAt(0) == '0') return "0";

    return answer.toString();
  }
}
