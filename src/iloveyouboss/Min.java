package iloveyouboss;

import java.util.ArrayList;
import java.util.List;

public class Min {
  public int[] solution(int[] arr) {

    // answer 배열로 return 해주기.
    if(arr.length == 1) {
      return new int[]{-1};
    }

    // 최소값 구하기.
    int currentMin = arr[0];
    for(int i = 1; i < arr.length; i++){
      currentMin = Math.min(currentMin, arr[i]);
    }

    // array 에서 최소값 빼주기.
    List<Integer> answerList = new ArrayList<>();
    for(int j = 0; j < arr.length; j++) {
      if(currentMin < arr[j]) {
        answerList.add(arr[j]);
      }
    }

    //answer 값 만들기.
    int[] answer = new int[answerList.size()];
    for (int i = 0; i < answerList.size(); i++) {
      answer[i] = answerList.get(i);
    }
    return answer;
  }
}
