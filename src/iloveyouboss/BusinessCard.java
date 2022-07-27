package iloveyouboss;

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
