package iloveyouboss;

import org.junit.Assert;
import org.junit.Test;

public class PrimeTest {

  private final Prime prime = new Prime();

  @Test
  public void test() {
    Assert.assertEquals(1, prime.solution(new int[]{1,2,3,4}));
    Assert.assertEquals(4, prime.solution(new int[]{1,2,7,6,4}));
  }

}
