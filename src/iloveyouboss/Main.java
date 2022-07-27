package iloveyouboss;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int K = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();

    for(int i = 0; i < K; i++) {
      int number = Integer.parseInt(br.readLine());
      if (number != 0) {
        stack.add(number);
      } else {
        stack.pop();
      }
    }

    br.close();

    int sum = 0;
    while (!stack.isEmpty()) {
      sum += stack.pop();
    }

    System.out.println(sum);
  }
}