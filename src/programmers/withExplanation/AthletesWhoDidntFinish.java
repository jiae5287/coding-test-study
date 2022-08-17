package programmers.withExplanation;

import java.util.HashMap;
import java.util.Map;


/**
 *
 *      <프로그래머스 : 완주하지 못한 선수>
 *      https://school.programmers.co.kr/learn/courses/30/lessons/42576
 *
 *      - 문제 설명 :
 *      수많은 마라톤 선수들이 마라톤에 참여하였습니다.
 *      단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 *      마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
 *      완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 *
 *      - 제한 사항 :
 *      마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 *      completion의 길이는 participant의 길이보다 1 작습니다.
 *      참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 *      참가자 중에는 동명이인이 있을 수 있습니다.
 *
 *      - 풀이 :
 *      0. HashMap을 사용 :  동명이인이 있어 Set은 불가능, 사람 이름으로 값을 찾아야 하는데 List는 index를 사용함.
 *                         순서가 중요한 것이 아니므로 Strack이나 Queue도 필요없음.
 *      1. participant의 원소들을 key로 하고, value가 0인 hashMap을 만듦.
 *      2. participant[]를 forEach 하여 hashMap의 원소를 가져오고 value를 1씩 증가시킴.
 *      3. completion[]를 forEach 하여 hashMap의 원소를 가져오고 value가 1씩 감소시킴.
 *      4. hashMap의 원소 중 value가 0이 아닌 key가 정답이 된다.
 *
 *      - 스스로 아쉬웠던 점 :
 *      getOrDefault()를 알지 못해서 forEach를 총 4번 돌림.
 *      participant[]의 원소들을 key로 하는, value가 0인, hashMap을 만들 때 1번.
 *      참여한 선수들을 체크하기 위해 value를 1 증가 시킬 때 1번.
 *      완주한 선수들은 빼기 위해 value를 1 감소 시킬 때 1번.
 *      정답을 찾기 위해 1번.
 *
 *      getOrDefault() : 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메서드
 *
 */


class AthletesWhoDidntFinish {
  public String solution(String[] participant, String[] completion) {

    String answer = "";
    Map<String, Integer> participantMap = new HashMap<>();

    // getOrDefault(key값, default값)는 value값이 없으면 default값을 return함.
    // key값을 호출할 때마다 +1을 해줌.
    for(String prt : participant) {
      participantMap.put(prt, participantMap.getOrDefault(prt, 0) + 1);
    }

    // key값을 호출할 때마다 -1을 해줌.
    for(String cmp : completion) {
      participantMap.put(cmp, participantMap.get(cmp) - 1);
    }

    // value값이 0이 아니라면 그것이 answer.
    for(String prt : participant) {
      if(participantMap.get(prt) != 0) {
        answer = prt;
      }
    }

    return answer;
  }
}