package programmers.withoutExplanation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathExam {

  public int[] solution(int[] answers) {
    int[] first = {1, 2, 3, 4, 5};
    int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    int[] studentScore = new int[3];

    // first, second, third를 어떻게 반복해야 할까..?
    for (int i = 0; i < answers.length; i++) {
      if (answers[i] == first[i % 5]) {
        studentScore[0]++;
      }
      if (answers[i] == second[i % 8]) {
        studentScore[1]++;
      }
      if (answers[i] == third[i % 10]) {
        studentScore[2]++;
      }
    }

    int[] result = studentScore;
    Arrays.sort(result);

    List<Integer> answer = new ArrayList<>();

    for(int i = 0; i < studentScore.length; i++) {
      if(result[2] == studentScore[i]) {
        answer.add(i + 1);
      }
    }
    return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
  }
}
