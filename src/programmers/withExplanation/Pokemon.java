package programmers.withExplanation;

import java.util.HashSet;
import java.util.Set;

public class Pokemon {

  /**
   *      << 프로그래머스 : 폰켓몬 >>
   *      https://school.programmers.co.kr/learn/courses/30/lessons/1845
   *
   *      - 문제 설명
   *      홍 박사님 연구실에 있는 총 N 마리의 폰켓몬 중에서 N/2마리를 가져올 수 있다.
   *      당신은 최대한 다양한 종류의 폰켓몬을 가지길 원한다.
   *      조건에 따라 최대한 많은 종류의 폰켓몬을 가져온다고 했을 때 몇 종류를 가져올 수 있나?
   *
   *      - 제한 사항
   *      nums는 폰켓몬의 종류 번호가 담긴 1차원 배열이다.
   *      nums의 길이(N)는 1 이상 10,000 이하의 자연수이며, 항상 짝수로 주어진다.
   *      폰켓몬의 종류 번호는 1 이상 200,000 이하의 자연수이다.
   *      가장 많은 종류의 폰켓몬을 선택하는 방법이 여러 가지인 경우에도,
   *      선택할 수 있는 폰켓몬 종류 개수의 최댓값 하나만 return 하면 된다.
   *
   *
   *      - 도출 과정
   *      포켓몬을 몇 마리 가져올 수 있을지 구해야 함.
   *      포켓몬이 몇 종이나 되는지 구해야 함 => set을 사용해서 개수를 구함
   *      포켓몬의 수가 포켓몬의 종류보다 많다면, 모든 종류의 포켄몬을 가져올 수 있다.
   *      포켓몬의 수가 포켄몬의 종류보다 적다면, 포켓몬의 수만큼의 종류만 가져올 수 있다.
   */

  public int solution(int[] nums) {
    // 포켓몬 몇 개 가져올 수 있는지 구하기.
    int n = nums.length / 2;

    // 포켓몬의 종류 구하기.
    Set<Integer> pokemonSet = new HashSet<>();
    for (int num : nums) {
      pokemonSet.add(num);
    }
    int pokemonPcs = pokemonSet.size();

    // 포켓몬의 개수 > 포켓몬 종류
    if (n > pokemonPcs) {
      return pokemonPcs;
    }
    // 포켓몬의 개수 == 포켓몬 종류 && 포켓몬의 개수 < 포켓몬 종류
    return n;
  }
}
