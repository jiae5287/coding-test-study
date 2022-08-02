package programmers;

import org.junit.Assert;
import org.junit.Test;
import programmers.withoutExplanation.Year;

public class YearTest {

  final static Year year = new Year();

  @Test
  public void test() {
    Assert.assertEquals("TUE", year.solution(5, 24));
  }

}
