package algorithm.test.baekjoon.level28.Exam02;

import java.util.Scanner;
import java.util.Stack;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Stack<Integer> stack = new Stack<>();
    int N = sc.nextInt();
    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    for (int i = 0; i < N; i++) {
      while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        arr[stack.pop()] = arr[i];
      }
      stack.push(i);
    }

    while (!stack.isEmpty()) {
      arr[stack.pop()] = -1;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append(arr[i]).append(' ');
    }
    System.out.println(sb);
  }
}
