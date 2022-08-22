package programmers.withExplanation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *      프로그래머스 :: 올바른 괄호
 *      https://school.programmers.co.kr/learn/courses/30/lessons/12909
 *
 *      - 문제 설명 :
 *      괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다.
 *      예를 들어 "()()" 또는 "(())()" 는 올바른 괄호입니다. ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
 *      '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고,
 *      올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
 *
 *      - 제한사항 :
 *      문자열 s의 길이 : 100,000 이하의 자연수
 *      문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
 *
 *      - solution1 :
 *      괄호는 순서가 중요한 문제이다.
 *      들어간 순서대로 나와야 하기 때문에 queue를 사용했다.
 *      괄호로 이루어진 문자열을 character Array로 변경하고, queue에 담았다. <= charAt을 사용하는 게 더 나음.
 *      queue의 size가 0이 될 때까지 poll을 해서 올바른 괄호 구성인지 확인한다.
 *      - 올바른 괄호 구성 조건 1 : 항상 '('의 개수가 ')'의 개수보다 많거나 같아야 한다.
 *      - 올바른 괄호 구성 조건 2 : 최종적으로 왼쪽의 개수와 오른쪽의 개수가 동일해야 한다.
 *      만약 틀린 구성이 생겼다면 false return.
 *      올바른 구성이라면 true return.
 *
 *      - solution2 :
 *      stack으로 풀었다.
 *      '(' 이면 push , ')'면 pop을 하여 처리하는 기본적인 스택문제!
 *      '('이면 stack에 push.
 *      ')'이면 stack에 있는 '('값을 pop
 *      만약!! ')'이라 stack에서 '('값을 pop해야 하는데 stack.size()가 0 이라면 return false. <= 괄호 순서 잘못됨.
 *      위의 계산이 모두 끝났는데 stack에 값이 남아있다면 여는 괄호와 닫는 괄호의 수가 달랐다는 의미이므로 return false.
 *      만약 아무 문제 없다면 return true.
 *
 *      - 아쉬운 점 :
 *      순서가 중요하다는 이유만으로 아무 생각없이 queue를 사용하는 것은 아쉬운 결정이었다.
 *      stack을 사용했을 때도 충분히 간단하게 풀 수 있는 문제였다.
 *
 *      시간복잡도 : O(n)
 *
 */
public class Bracket {
  boolean solution1(String s) {

    // 들어간 순서대로 나와야 하기 때문에 queue를 사용했다.
    Queue<Character> bracketQueue = new LinkedList<>();

    // 괄호로 이루어진 문자열을 char 쪼개서 queue에 담았다.
    for(int i = 0; i < s.length(); i++) {
      bracketQueue.add(s.charAt(i));
    }

    int left = 0; // '('의 개수
    int right = 0; // ')'의 개수

    // queue의 size가 0이 될 때까지 poll을 해서 올바른 괄호 구성인지 확인한다.
    while (bracketQueue.size() != 0) {

      char c = bracketQueue.poll();
      if (c == '(') left++;
      else if (c == ')') right++;

      // 항상 '('의 개수가 ')'의 개수보다 많거나 같아야 한다.
      if (right > left) return false;
    }

    // '('와 ')'의 개수가 동일하지 않을 때 false, 동일하면 true.
    return left == right;
  }

  boolean solution2(String s) {
    Stack<Character> stack = new Stack<>();

    for(int i = 0; i < s.length(); i++){
      char c = s.charAt(i);

      //여는 괄호일 때
      if(c == '('){
        stack.push(c);
      }

      //닫는 괄호일 때
      if(c == ')'){
        if(stack.size() == 0){
          return false;
        }
        else stack.pop();
      }
    }

    // '('와 ')'의 개수가 동일하지 않을 때 false, 동일하면 true.
    return stack.size() == 0;
  }

}
