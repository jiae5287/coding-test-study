package codility;

/**
 *    codility :: BinaryGap
 *
 *    a binary gap within a positive integer N is any maximal sequence of consecutive zeros
 *    that is surrounded by ones at both ends in the binary representation of N.
 *
 *    For example, number 9 has binary representation 1001 and contains a binary gap of length 2.
 *    The number 529 has binary representation 1000010001 and contains two binary gaps. one of
 *    length 4 and one of length 3. The number 20 has binary representation 10100 and contains
 *    one binary gap of length 1. The number 15 has binary representation 1111 and has no binary
 *    gaps. The number 32 has binary representation 100000 and binary gaps.
 *
 *    Write a function:
 *
 *      class Solution { public int solution(int N); }
 *
 *     that, given a positive integer N, returns the length of its longest binary gap.
 *     The function should return 0 if N doesn't contain a binary gap.
 *
 *     For example,
 *     given N = 1041 the function should return 5,
 *     because N has binary representation 10000010001 and so its longest binary gap is of length 5.
 *     Given N = 32 the function should return 0,
 *     because N has binary representation '100000' and thus no binary gaps.
 *
 *      Write an efficient algorithm for the following assumptions:
 *
 *      N is an integer within the range [1..2,147,483,647].
 *
 *      해석 :
 *      10진수 N이 주어진다.
 *      이를 이진수로 바꿨을 때, 1과 1 사이에 있는 0의 개수를 센 후, 가장 긴 개수를 출력하라.
 *      만약 1과 1 사이에 있는 0이 없다면 0을 return 하라.
 *
 *      풀이 :
 *      Integer.toBinaryString(N)을 사용하여 10진수를 2진수로 변경하여 String type으로 return한다.
 *      String.toCharArray()를 이용해 해당 값을 char[] 변경하고
 *      해당 배열의 원소를 하나씩 꺼내서,
 *      만약 원소값이 '0'이면 zeros++를 해주고 (zeros : binary gap의 길이를 저장하는 변수)
 *      원소값이 '1'이라면 binary gap 중에 가장 큰 값인지 확인하고, zeros를 초기화한다.
 *
 *
 */
public class BinaryGap {

  public static void main(String[] args) {
    System.out.println(solution(529));
  }

  public static int solution(int N) {
    // write your code in Java SE 8
    String str = Integer.toBinaryString(N);

    int answer = 0;
    int zeros = 0;
    for (char c : str.toCharArray()) {
      if (c == '0') zeros++;
      if (c == '1')
      {
        if (answer < zeros) answer = zeros;
        zeros = 0;
      }
    }
    return answer;
  }
}
