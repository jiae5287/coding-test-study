package codeup;

import static org.junit.Assert.*;
import org.junit.Test;

public class Q1001Test {

  private final Q1001 q1001 = new Q1001();
  private final String hello = "Hello";
  private final String helloWorld = "Hello World";
  private final String helloAndWorld = "Hello\nWorld";
  private final String helloSingleQuotationMarks = "'Hello'";
  private final String helloDoubleQuotationMarks = "\"Hello\"";
  private final String specialAlphabet = "\"!@#$%^&*()\"";
  private final String directoryAddress = "\"C:\\Download\\hello.cpp\"";
  private final String unicode = "\u250C\u252C\u2510\n\u251C\u253C\u2524\n\u2514\u2534\u2518";

  @Test
  public void test() {
    assertEquals(hello, q1001.hello());
    assertEquals(helloWorld, q1001.helloWorld());
    assertEquals(helloAndWorld, q1001.helloAndWorld());
    assertEquals(helloSingleQuotationMarks, q1001.helloSingleQuotationMarks());
    assertEquals(helloDoubleQuotationMarks, q1001.helloDoubleQuotationMarks());
    assertEquals(specialAlphabet, q1001.specialAlphabet());
    assertEquals(directoryAddress, q1001.directoryAddress());
    assertEquals(unicode, q1001.unicode());
  }
}
