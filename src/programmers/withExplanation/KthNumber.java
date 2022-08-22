package programmers.withExplanation;

import java.util.Arrays;


/**
 *    프로그래머스 :: k번째 수
 *    https://school.programmers.co.kr/learn/courses/30/lessons/42748
 *
 *
 *    - 문제 설명 :
 *    배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
 *
 *    예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면,
 *    1. array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
 *    2. 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
 *    3. 2에서 나온 배열의 3번째 숫자는 5입니다.
 *
 *    배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
 *    commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하는 함수를 작성해주세요.
 *
 *
 *    - 제한 사항 :
 *    array의 길이는 1 이상 100 이하입니다.
 *    array의 각 원소는 1 이상 100 이하입니다.
 *    commands의 길이는 1 이상 50 이하입니다.
 *    commands의 각 원소는 길이가 3입니다.
 *
 *    - 문제 풀이 :
 *    Arrays.copyOfRange() 메소드 활용
 *    copyOfRange(원본 배열, 복사할 시작 인덱스, 복사할 끝 인덱스)
 *    Arrays.sort 사용
 *    => API를 사용하지 않는 법으로도 solution2에서 풀었다.
 *
 *    시간복잡도 : O(N*M)
 *
 */
public class KthNumber {
  // api 사용.
  public int[] solution1(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];

    for(int a = 0; a < commands.length; a++ ) {
      int i = commands[a][0]; // i번째부터 ~
      int j = commands[a][1]; // j번째까지 자른 배열
      int k = commands[a][2]; // 오름차순으로 정렬했을 때 k번째 수
      int[] result = Arrays.copyOfRange(array, i - 1, j);
      Arrays.sort(result);
      answer[a] = result[k - 1];
    }

    return answer;
  }

  // api 사용 안 함.
  public int[] solution2(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];

    for (int i = 0; i < commands.length; i++) {
      int start = commands[i][0]; // i번째부터 ~
      int end = commands[i][1]; // j번째까지 자른 배열
      int k = commands[i][2]; // 오름차순으로 정렬했을 때 k번째 수
      int[] splitArray = new int[end - start + 1];
      int index = 0;
      for (int j = start - 1; j < end; j++) {
        splitArray[index] = array[j];
        index++;
      }
      Arrays.sort(splitArray);
      answer[i] = splitArray[k - 1];
    }

    return answer;
  }
}

