package programmers.withoutExplanation;


import java.util.ArrayList;
import java.util.List;

public class StackAndQueue {
  public int[] solution(int[] progresses, int[] speeds) {
    int[] works = {progresses.length};
    for(int i = 0; i < progresses.length; i++) {
      // progresses + (speeds * n) = 100
      // (100 - progresses) / speeds = n
      // (100 - 30) / 30 = 2.xxx => 올림을 해주면 됩니다.
      // (100 - 90) / 1 = 10
      int r = (100 - progresses[i]) % speeds[i];
      int n = (100 - progresses[i]) / speeds[i];
      if (r > 0) {
        works[i] = n + 1;
      }
      works[i] = n;
    }

    List<Integer> answerList = new  ArrayList<>();
    int w = 1;
    int max = 0;
    for(int i = 0; i < works.length - 1; i++) {
      // 5일 < 10일 :: 기능 1개
      // 10일 > 1일, 10일 > 1일 :: 기능 3개
      // 20일 > 1일 :: 기능 2개
      //{5, 10, 1, 1, 20, 1}
      if(works[i] < works[i + 1]) {

      }
    }

    int[] answer = {};
    return answer;
  }
}
