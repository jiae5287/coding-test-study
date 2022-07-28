package programmers;

import java.util.*;

public class PreNum {
  public int[] solution(int []arr) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    int preNum = -1;
    for(int num : arr) {
      if(preNum != num) {
        list.add(num);
      }
      preNum = num;
    }
    int[] answer = new int[list.size()];
    for(int i=0; i<answer.length; i++) {
      answer[i] = list.get(i).intValue();
    }
    return answer;
  }
}