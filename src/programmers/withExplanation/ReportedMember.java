package programmers.withExplanation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReportedMember {

  /**
   *    <<프로그래머스 :: 신고 결과 받기>>
   *    https://school.programmers.co.kr/learn/courses/30/lessons/92334
   *
   *    - 문제 설명 :
   *    각 유저는 한 번에 한 병의 유저를 신고할 수 있다.
   *    신고 횟수엔 제한이 없지만 동일한 유저에 대한 신고 횟수는 1회로 처리한다.
   *    k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실이 메일로 발송된다.
   *    id_list : 전체 유저 목록, k : k번 이상 신고당하면 이용 정지, report : 정지된 유저 목록
   *    각 유저별로 처리 결과 메일을 받은 횟수를 배열에 담아 return.
   *
   *    - 제한 사항 :
   *    2 ≤ id_list의 길이 ≤ 1,000
   *    1 ≤ id_list의 원소 길이 ≤ 10
   *    id_list의 원소는 이용자의 id를 나타내는 문자열이며 알파벳 소문자로만 이루어져 있습니다.
   *    id_list에는 같은 아이디가 중복해서 들어있지 않습니다.
   *    1 ≤ report의 길이 ≤ 200,000
   *    3 ≤ report의 원소 길이 ≤ 21
   *    report의 원소는 "이용자id 신고한id"형태의 문자열입니다.
   *    예를 들어 "muzi frodo"의 경우 "muzi"가 "frodo"를 신고했다는 의미입니다.
   *    id는 알파벳 소문자로만 이루어져 있습니다.
   *    이용자id와 신고한id는 공백(스페이스)하나로 구분되어 있습니다.
   *    자기 자신을 신고하는 경우는 없습니다.
   *    1 ≤ k ≤ 200, k는 자연수입니다.
   *    return 하는 배열은 id_list에 담긴 id 순서대로 각 유저가 받은 결과 메일 수를 담으면 됩니다.
   *    !! 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다. 그 횟수를 return !!
   *
   *
   *    - 나의 도출 과정
   *    탐색 문제!! 어떤 자료구조를 사용할 것인지가 중요!!
   *    1. 신고하기 전에 중복된 신고인지 확인하기. => Set을 사용해서 중복 제거
   *    2. 신고한 유저가 누굴 신고했는지 확인하는 hashMap 만들기 => hashMap<신고당한 유저, 신고한 유저들 id set>
   *    3. report에서 신고당한 사람과 신고한 사람들을 추출해서 2.의 hashMap에 담기
   *    4. 전체 아이디 가져와서 메일 받는 횟수를 저장하는 hashmap 만들기 => hashMap<유저 아이디, 메일을 받는 횟수>
   *    5. 2.의 hashMap의 value Set의 size를 k와 비교해,
   *       신고한 유저들을 확인해서 4.의 hashMap에 카운트 해주기
   *    6. id_list에 담긴 id 순서대로 각 유저가 받은 결과 메일 수를 담아서 return
   *
   */

  public int[] solution(String[] id_list, String[] report, int k) {
    // 1. hashMap<String, set> 신고당한 사람 : 신고한 사람들 집합
    Map<String, Set<String>> reportedUserMap = new HashMap<>();

    for(String r : report) {
      // split을 이용해서 String을 2개로 쪼개기
      String[] pair = r.split(" ");
      String reported = pair[1]; // 신고당한 사람
      String reporter = pair[0]; // 신고한 사람
      // 해당 키값이 있는지 확인하고 있다면 해당 키로 값 넣어주고, 없다면 만들어서 값 넣어주기.
      if (!reportedUserMap.containsKey(reported)) {
        reportedUserMap.put(reported, new HashSet<>());
      }
      reportedUserMap.get(reported).add(reporter);
    }

    Map<String, Integer> reporterUserCountMap = new HashMap<>();

    // 2. 결과값 만들기
    reportedUserMap.entrySet().forEach(entry -> {
      if(k <= entry.getValue().size()) { // reportedUserMap의 Value set의 size()가 k보다 크거나 같으면,
        for(String reporter : entry.getValue()) { // value의 Set에 들어있는 신고자들을 뽑아서,
          // reporterUserCountMap에서 아이디를 찾아 메일 받는 횟수를 저장.
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
