package iloveyouboss;

public class SwitchNumber {
  public int[] solution(long n) {
    String numberString = Long.toString(n);
    char[] charNumbers = numberString.toCharArray();
    int[] answer = new int[charNumbers.length];
    int i = 0;
    for (int j = charNumbers.length - 1; j >= 0; j--) {
      answer[i] = Character.getNumericValue(charNumbers[j]);
      i++;
    }
    return answer;
  }
}
