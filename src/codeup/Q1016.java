package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1016 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    float num = Float.parseFloat(br.readLine());
    System.out.println(String.format("%.3f", num));
  }
}
