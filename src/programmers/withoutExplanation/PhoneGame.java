package programmers.withoutExplanation;

public class PhoneGame {
  public String solution(int[] numbers, String hand) {
    StringBuilder sb = new StringBuilder();
    int leftIndex = 10;	 // '*' => 10으로 치환
    int rightIndex = 12; // '#' => 12로 치환

    for(int number : numbers) {
      if(number == 1 || number == 4 || number == 7) { // Left
        leftIndex = number;
        sb.append("L");
      } else if(number == 3 || number == 6 || number == 9) {	// Right
        rightIndex = number;
        sb.append("R");
      } else { // Center
        int leftLength = getLength(leftIndex, number);
        int rightLength = getLength(rightIndex, number);

        if(leftLength > rightLength) {
          rightIndex = number;
          sb.append("R");
        } else if(leftLength < rightLength) {
          leftIndex = number;
          sb.append("L");
        } else {
          if(hand.equals("right")) {
            rightIndex = number;
            sb.append("R");
          } else {
            leftIndex = number;
            sb.append("L");
          }
        }
      }
    }
    return sb.toString();
  }

  private int getLength(int index, int number) {

    // 숫자 0의 경우 11로 치환
    index = (index == 0) ? 11 : index;
    number = (number == 0) ? 11 : number;

    int x = (index - 1) % 3;
    int y = (index - 1) / 3;
    int numberX = 1;
    int numberY = (number - 1) / 3;

    return Math.abs(x-numberX) + Math.abs(y-numberY);
  }
}
