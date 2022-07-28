package programmers;

import java.util.Arrays;

public class Greedy {

  // 여벌의 체육복
  // 학생번호는 체격 순
  // 바로 앞번호의 학생, 뒷번호의 학생에게만 빌려줌
  // 체육복이 없으면 수업을 들을 수 없음
  // 최대한 많은 학생이 수업을 들어야 함

  // 전체 학생수 n (2 ~ 30)
  // 체육복을 도난당한 학생들의 번호 배열 lost (1명에서 n명 이하, 중복 없음)
  // 여벌 체육복이 있는 학생들 번호 배열 reverse (1명에서 n명 이하, 중복 없음)
  // 여벌 체육복이 있는 학생만 체육복을 빌려줄 수 있음
  // 여벌 체육복이 있는 학생도 도난당했을 수 있음, 체육복이 하나만 있는 상황이라면 체육복을 빌려줄 수 없음
  // 최댓값 return 하도록 해라

  public int solution(int n, int[] lost, int[] reserve) {
    // 기본 셋팅
    int answer = 0;
    int[] student = new int[n];
    Arrays.fill(student, 1);

    // 체육복 잃어버린 사람 셋팅
    for (int i : lost) {
      student[i - 1] -= 1;
    }

    // 체육복 여분이 있는 사람 셋팅
    for (int i : reserve) {
      student[i - 1] += 1;
    }

    // 빌려주기
    for (int i = 0; i < student.length; i++) {
      if (student[i] == 0) {
        if (i > 0 && student[i - 1] == 2) { //왼쪽 검사
          student[i - 1] -= 1;
          student[i] += 1;
        } else if (i < n - 1 && student[i + 1] == 2) { //오른쪽 검사
          student[i + 1] -= 1;
          student[i] += 1;
        }
      }
    }

    for (int i = 0; i < student.length; i++) {
      if (student[i] >= 1) {
        answer++;
      }
    }

    return answer;
  }
}
