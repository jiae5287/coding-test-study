package iloveyouboss;

public class NumStringChange {

  public int solution(String s) {
    int answer = 0;
    String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    for (int i = 0; i < 10; i++) {
      s.replace(nums[i], String.valueOf(i));
    }
    answer = Integer.parseInt(s);
    return answer;
  }

}
