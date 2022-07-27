package iloveyouboss;

import java.util.HashMap;
import java.util.Map;

class Hash {
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