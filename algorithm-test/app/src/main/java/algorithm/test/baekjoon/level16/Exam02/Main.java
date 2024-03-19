package algorithm.test.baekjoon.level16.Exam02;

import java.util.Scanner;
import java.util.Stack;

// 10773 제로
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Stack<Integer> stack = new Stack<Integer>();

    int k = sc.nextInt();

    for (int i = 0; i<k; i++) {
      int num = sc.nextInt();

      if (num ==0) {
        stack.pop();
      } else {
        stack.push(num);
      }
    }
    int sum = 0;

    for (int i : stack) {
      sum += i;
    }
    System.out.println(sum);
  }
}
