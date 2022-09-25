package codility;

import java.util.HashSet;
import java.util.Set;


/**
 *    codility : MissingInteger
 *
 *    This is a demo task.
 *
 *    write a function :
 *    class solution { public int solution(int[] A);}
 *    that, given an array A of N integers, returns the smallest positive integer (greater than 0)
 *    that does not occur in A.
 *
 *    For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 *    Given A = [1, 2, 3], the function should return 4.
 *    Given A = [-1, -3], the function should return 1.
 *
 *    write an efficient algorithm for the following assumptions:
 *
 *    * N is an integer within the range  [1..100,000];
 *    * each element of array A is an integer within the range [−1,000,000..1,000,000].
 *
 *
 *    해석 :
 *
 *    길이가 N인 배열 A가 주어진다.
 *    배열 A에 들어있지 않은 가장 작은 양의 정수값을 반환하라.
 *    예를 들면,
 *    A = [1, 3, 6, 4, 1, 2] => A에 없는 수중 가장 작은 양의 정수는 5다.
 *    A = [-1, -3] => A에 없는 수 중 가장 작은 양의 정수는 1이다.
 *    A = [1, 2, 3] => A에 없는 수 중 가장 작은 양의 정수는 4이다.
 *
 *    문제 해결 :
 *    1. 중복된 수를 제거하기 위해 Set에 넣는다.
 *    2. Set에 넣을 때 음수는 제외한다. <= 가장 작은 양의 정수를 구해야 하기 때문에
 *    3-0. HashSet의 contain()을 이용하여 Set에 들어있지 않은 수 중 가장 작은 수를 도출해냅니다.
 *    3-1. for문의 변수 i를 이용해, HashMap에 i와 매칭되는 숫자가 있다면 통과
 *    3-2. HashMap에 i와 매칭되는 숫자가 있다면 break를 걸고 i를 answer로 return.
 *    !! HashSet에서 contains()는 O(1)이므로 총 O(N)으로 해결할 수 있다. !!
 *
 *
 */
public class MissingInteger {

  public static void main(String[] args) {
    int[] A = {1, 2, 3, 1, 5, 6};
    System.out.println(solution(A));
  }

  public static int solution(int[] A) {

    Set<Integer> set = new HashSet<>();
    for (int element : A) {
      if (element > 0) {
        set.add(element);
      }
    }

    int answer = 1;
    for (int i = 1; i < Integer.MAX_VALUE; i++) {
      if (!set.contains(i)) {
        answer = i;
        break;
      }
    }

    return answer;
  }
}
