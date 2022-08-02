package programmers.withoutExplanation;

public class Year {
  //무슨 요일인지 리턴하는 함수 만들기.
  // 월, 날짜
  // 2016년의 몇번째 날?
  // 무슨 요일? 이제 나누기해야 함.
  public String solution(int a, int b) {
    return getDay(getNthDayOf2016(a, b));
  }


  //2016년의 몇번째 날?
  public int getNthDayOf2016(int month, int date) {

    final int[] MONTHS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int nthDay = 0;

    for(int i = 0; i < month - 1; i++) {
      nthDay += MONTHS[i];
    }
    nthDay += date;

    return nthDay;
  }

  //무슨 요일?
  public String getDay(int date) {

    int day = date % 7;

    switch (day) {
      case 0:
        return "THU";
      case 1:
        return "FRI";
      case 2:
        return "SAT";
      case 3:
        return "SUN";
      case 4:
        return "MON";
      case 5:
        return "TUE";
      case 6:
        return "WED";
    }

    return "ERROR";
  }

}
