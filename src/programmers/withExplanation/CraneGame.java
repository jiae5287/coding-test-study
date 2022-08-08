package programmers.withExplanation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CraneGame {

  /**
   * 정리 중!
   */

  public int solution(int[][] board, int[] moves) {
    // 기본
    int answer = 0;
    List<Integer> dollBox = new ArrayList<>();
    for (int i = 0; i < moves.length; i++) {
      moves[i] = moves[i] - 1;
    }

    for (int i = 0; i < moves.length; i++) {
      int n = moves[i];
      for (int j = 0; j < board.length; j++) {
        if (board[j][n] != 0) {
          dollBox.add(board[j][n]);
          board[j][n] = 0;
        }
      }
    }

    // 이때 바구니의 가장 아래 칸부터 인형이 순서대로 쌓이게 됩니다.
    // stack을 사용한다.
    Stack<Integer> basket = new Stack<>();
    for (int doll : dollBox) {
      if (basket.size() != 0 && basket.peek().equals(doll)) {
        basket.pop();
        answer += 2;
        continue;
      }
      basket.push(doll);
    }




    return answer;
  }
}
