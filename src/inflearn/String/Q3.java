package inflearn.String;

import java.util.Scanner;

/**
 *
 *      문장 속 단어 문제
 *
 *      설명 :
 *      한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
 *      문장속의 각 단어는 공백으로 구분됩니다.
 *
 *      입력 :
 *      첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다.
 *      문장은 영어 알파벳으로만 구성되어 있습니다.
 *
 *      출력 :
 *      첫 줄에 가장 긴 단어를 출력한다.
 *      가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한 단어를 답으로 합니다.
 *
 *      solution 풀이 :
 *      split으로 input값을 쪼개서 배열에 넣는다.
 *      배열의 원소 중 단어의 길이가 가장 긴 값의 length를 max에 저장하고, 그 인덱스값을 idx에 저장한다.
 *      for문을 돌린 후 idx값을 이용해 answer값을 찾는다.
 *
 *      solution2 풀이 :
 *      indexOf를 이용해 띄어쓰기가 있는 곳의 index를 알아낸다.
 *      해당 index를 이용해서 단어를 하나씩 추출한다.
 *      추출한 단어 중 가장 긴 단어를 찾아 answer에 넣어준다.
 *      문장의 가장 마지막에 있는 단어가 가장 긴 단어라면 while문이 끝난 이후에 처리해준다.
 *      가장 마지막 단어에는 ' '이 존재하지 않기 때문에 while문을 돌 수 없기 때문이다.
 *
 */
public class Q3 {

  public static void main(String[] args) {
    Q3 main = new Q3();
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    System.out.println(main.solution2(input));
  }

  // split() 사용하는 방법
  public String solution(String str) {

    String[] words = str.split(" ");
    int max = Integer.MIN_VALUE; // integer 최소값.
    int idx = 0;

    for (int i = 0; i < words.length; i++) {
      int len = words[i].length();
      if (max < len) {
        max = len;
        idx = i;
      }
    }

    return words[idx];
  }

  // indexOf(), subString() 사용하는 방법
  public String solution2(String str) {
    String answer = "";
    int idx;
    int max = Integer.MIN_VALUE;

    while ((idx = str.indexOf(' ')) != -1) {
      String word = str.substring(0, idx);
      int len = word.length();
      if (max < len) {
        max = len;
        answer = word;
      }
      str = str.substring(idx + 1);
    }

    // 마지막 단어가 제일 긴 단어인 경우, while문이 끝난 후 answer에 마지막 단어를 넣는다.
    // 가장 마지막 단어에는 ' '이 존재하지 않기 때문에 while문을 돌 수 없다.
    if (max < str.length()) answer = str;

    return answer;
  }
}
