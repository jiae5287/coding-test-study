package programmers.withExplanation;


import java.util.Arrays;

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
