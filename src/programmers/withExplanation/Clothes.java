package programmers.withExplanation;


import java.util.HashMap;
import java.util.Map;

/**
 *    프로그래머스 :: 위장
 *    https://school.programmers.co.kr/learn/courses/30/lessons/42578
 *
 *    - 문제 설명 :
 *    스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장한다.
 *    예를 들어 스파이가 가진 옷이 아래와 같고
 *    오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면
 *    다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
 *    스파이가 가진 의상들이 담긴 2차원 배열 clothes[][]가 주어질 때,
 *    서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
 *
 *    - 제한 사항 :
 *    * clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
 *    * 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
 *    * 같은 이름을 가진 의상은 존재하지 않습니다.
 *    * clothes의 모든 원소는 문자열로 이루어져 있습니다.
 *    * 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
 *    * 스파이는 하루에 최소 한 개의 의상은 입습니다.
 *
 *    - 내 풀이 :
 *    주어진 값이 아래와 같다고 했을 때,
 *    [["yellow_hat", "headgear"], ["blue_sunglasses", "eye_wear"], ["green_turban", "headgear"]]
 *    경우의 수를 생각해보자.
 *
 *    case 1 : headgear 선택지는 몇 개?
 *    0. 복수로 동시 착용 불가
 *    1. yellow_hat을 아예 안 쓰는 경우 (다른 옷을 입음)
 *    2. yellow_hat을 쓴 경우
 *    3. green_turban을 쓴 경우
 *
 *    case 2 : eye_wear 선택지는 몇 개?
 *    0. 복수로 동시 착용 불가
 *    1. blue_sunglasses를 안 쓴 경우 (다른 옷을 입음)
 *
 *    해당 종류의 옷을 안 입는 경우도 포함하여 계산해야 한다.
 *    따라서, (headgear 개수 + 1) * (eye_wear 개수 + 1) 라는 식을 이용해 해당 case의 답을 찾을 수 있다.
 *    이것을 일반식으로 만들면 {(종류 당 옷의 개수) + 1} * {(종류 당 옷의 개수) + 1} * ... 가 된다.
 *    단! 여기서 빠트리지 말아야 할 점은 일반식의 답에는 어떤 옷도 입지 않은 경우가 포함되어있다는 것이다.
 *    따라서 일반식의 답 - 1(아무 옷도 안 입는 경우)을 해줘야 한다.
 *
 *
 *    - 아쉬운 점 :
 *    Set을 사용해서 옷 종류를 알아내고, List를 이용해서 답을 계산하려고 했다.
 *    하지만 이 문제에서 필요했던 것은 종류 당 옷의 개수였다.
 *    따라서 Map<종류, 개수>를 이용하여 case들을 구하는 방식이 더 올바른 방식이었다.
 *    중복되지 않은 값들이 있고, 그 값들이 어떤 의미를 가진다면 Map을 사용하는 것이 좋겠다고 생각했다.
 *
 */
public class Clothes {
  public int solution(String[][] clothes) {
    int answer = 1;
    int cases = 0;
    Map<String, Integer> clothedType = new HashMap<>();

    // 옷 종류별 개수 세기
    for (String[] cloth : clothes) {
      clothedType.put(cloth[1], clothedType.getOrDefault(cloth[1], 0) + 1);
    }

    for (String key : clothedType.keySet()) { // clothedType 원소 1개씩 가져오기.
      cases = clothedType.get(key).intValue(); // 해당 종류의 옷 개수
      cases = cases + 1; // 해당 종류의 옷을 입지 않은 경우
      answer = answer * cases; // 경우의 수
    }

    answer = answer - 1; // 옷을 아예 안 입은 경우 제외

    return answer;
  }
}
