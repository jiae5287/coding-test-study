package programmers.withExplanation;

/**
 *        <프로그래머스 :: 최소직사각형>
 *        https://school.programmers.co.kr/learn/courses/30/lessons/86491
 *
 *        문제 설명 :
 *        명함 지갑을 만드는 회사에서 지갑의 크기를 정하려고 합니다.
 *        다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서, 작아서 들고 다니기 편한 지갑을 만들어야 합니다.
 *        이러한 요건을 만족하는 지갑을 만들기 위해 디자인팀은 모든 명함의 가로 길이와 세로 길이를 조사했습니다.
 *        아래 표는 4가지 명함의 가로 길이와 세로 길이를 나타냅니다.
 *
 *        명함 번호	가로 길이	세로 길이
 *        1	      60	    50
 *        2	      30	    70
 *        3	      60	    30
 *        4	      80	    40
 *
 *        가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에
 *        80(가로) x 70(세로) 크기의 지갑을 만들면 모든 명함들을 수납할 수 있습니다.
 *        하지만 2번 명함을 가로로 눕혀 수납한다면 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다.
 *        이때의 지갑 크기는 4000(=80 x 50)입니다.
 *        모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다.
 *        모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.
 *
 *        제한 사항 :
 *        sizes의 길이는 1 이상 10,000 이하입니다.
 *        sizes의 원소는 [w, h] 형식입니다.
 *        w는 명함의 가로 길이를 나타냅니다.
 *        h는 명함의 세로 길이를 나타냅니다.
 *        w와 h는 1 이상 1,000 이하인 자연수입니다.
 *
 *        풀이 :
 *        원래의 가로와 세로에 집중하지 않고, 길이가 긴쪽을 세로 길이가 짧은 쪽을 세로로 본다.
 *        따라서 명함을 받으면 길이가 긴 것을 세로 list에 넣고, 길이가 짧은 것을 가로 list에 넣는다.
 *        가로 list에서 가장 큰 값과 세로 list에서 가장 큰 값을 뽑아 곱하여 값을 return한다.
 *
 */
public class BusinessCard {

  public int solution(int[][] sizes) {

    int[] longLineSegments = new int[sizes.length];
    int[] shortLineSegments = new int[sizes.length];

    // 명함 정렬하기
    for (int i = 0; i < sizes.length; i++) {
      longLineSegments[i] = Math.max(sizes[i][0], sizes[i][1]);
      shortLineSegments[i] = Math.min(sizes[i][0], sizes[i][1]);
    }

    // 길이가 긴 면 중 가장 긴 것 구하기
    int longLineLongest = 0;
    for (int i = 0; i < longLineSegments.length; i++) {
      if (longLineSegments[i] > longLineLongest) {
        longLineLongest = longLineSegments[i];
      }
    }

    // 길이가 짧은 면 중 가장 긴 것 구하기
    int shortLineLongest = 0;
    for (int i = 0; i < shortLineSegments.length; i++) {
      if (shortLineSegments[i] > shortLineLongest) {
        shortLineLongest = shortLineSegments[i];
      }
    }

    return longLineLongest * shortLineLongest;
  }
}
