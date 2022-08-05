package programmers.withExplanation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReportedMember {

  /**
   *    정리 중!!
   *
   *    신고 하기 전에 중복된 신고인지 확인하기.
   *    신고한 사람 : 신고 당한 id 리스트
   *    !! 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다. 그 횟수를 return !!
   *    각 회원당 set, 본인을 신고한 사람이름. hashMap<String, set> 신고당한 사람 : 신고한 사람들 집합
   *    hashMap<String, Integer> : 신고당한 유저 : 신고 접수된 횟수 => k랑 비교
   *    int[] result
   *    전체 아이디 가져와서 신고당한 횟수 체크하는 hashmap 만들기.
   *    탐색 문제!! 어떤 자료구조를 사용할 것인지.
   *
   */

  public int[] solution(String[] id_list, String[] report, int k) {
    // 1. hashMap<String, set> 신고당한 사람 : 신고한 사람들 집합
    Map<String, Set<String>> reportedUserMap = new HashMap<>();

    for(String r : report) {
      String[] pair = r.split(" ");
      String reported = pair[1];
      String reporter = pair[0];
      if (!reportedUserMap.containsKey(reported)) {
        reportedUserMap.put(reported, new HashSet<>());
      }
      reportedUserMap.get(reported).add(reporter);
    }

    Map<String, Integer> reporterUserCountMap = new HashMap<>();

    // 2. 결과값 만들기
    reportedUserMap.entrySet().forEach(entry -> {
      if(k <= entry.getValue().size()) {
        // muzi, frodo
        for(String reporter : entry.getValue()) {
          if(!reporterUserCountMap.containsKey(reporter)) {
            reporterUserCountMap.put(reporter, 0);
          }
          Integer a = reporterUserCountMap.get(reporter) + 1;
          reporterUserCountMap.put(reporter, a);
        }
      }
    });

    //3. 순서대로 답 내기
    int[] answer = new int[id_list.length];
    // id_list[i] 값을 가져와서 => reporterUserCountMap key값 찾기 => answer[i]
    for(int i = 0; i < id_list.length; i++) {
      answer[i] = reporterUserCountMap.getOrDefault(id_list[i], 0);
    }
    return answer;
  }
}
