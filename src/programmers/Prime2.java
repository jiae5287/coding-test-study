package programmers;

public class Prime2 {
  // 숫자 n을 받음
  // 1부터 n 까지의 숫자 중 소수의 개수 (1은 소수가 아님)
  // 자기자신의 제곱근 보다 작거나 같은 1을 제외한 자연수로 나눴는데 나눠지지 않는다면 소수.
  public int solution(int n) {
    int answer = 0;
    for (int i = 2; i <= n; i++) {
      answer += isPrime(i) ? 1 : 0;
    }
    return answer;
  }

  public boolean isPrime(int n) {
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      };
    }
    return true;
  }

}
