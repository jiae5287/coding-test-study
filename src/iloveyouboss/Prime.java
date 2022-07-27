package iloveyouboss;

public class Prime {

  public int solution(int[] nums) {
    return countPrime(nums);
  }

  //중복 없이 3개의 수 더하기
  public int countPrime(int[] nums) {

    int answer = 0;

    for(int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        for (int f = j + 1; f < nums.length; f++) {
          answer += isPrime(nums[i] + nums[j] + nums[f]) ? 1:0;
        }
      }
    }

    return answer;
  }

  // 세 숫자의 합 리스트 중 몇 개가 소수인지 확인하기
  public boolean isPrime(int sum) {

      for(int j = 2; j <= Math.sqrt(sum); j++) {
        // 나머지가 없는 경우. 나누어 떨어지는 경우.
        if(sum % j == 0) {
          return false;
        }
      }
    return true;
  }
}
