package algorithm.test.baekjoon.level16.Exam09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 28279 덱 2
public class Main {
  static StringBuilder sb = new StringBuilder();
  static Deque<Integer> deque = new ArrayDeque<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());

    while (N --> 0) {
      st = new StringTokenizer(br.readLine());
      int order = Integer.parseInt(st.nextToken());

      switch (order) {
        case 1:
          frontPush(Integer.parseInt(st.nextToken()));
          break;

        case 2:
          backPush(Integer.parseInt(st.nextToken()));
          break;

        case 3:
          frontPop();
          break;

        case 4:
          backPop();
          break;

        case 5 :
          dequeSize();
          break;

        case 6 :
          dequeEmpty();
          break;

        case 7 :
          getFront();
          break;

        case 8 :
          getBack();
          break;
      }
    }
    br.close();
    System.out.println(sb);
  }

  static void frontPush(int num) {
    deque.addFirst(num);
  }

  static void backPush(int num) {
    deque.addLast(num);
  }

  static void frontPop() {
    if (deque.isEmpty()) {
      sb.append("-1").append("\n");
      return;
    }
    sb.append(deque.pollFirst()).append("\n");
  }

  static void backPop() {
    if (deque.isEmpty()) {
      sb.append("-1").append("\n");
      return;
    }
    sb.append(deque.pollLast()).append("\n");
  }
  static void dequeSize() {
    sb.append(deque.size()).append("\n");
  }
  static void dequeEmpty() {
    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
  }

  static void getFront() {
    if (deque.isEmpty()) {
      sb.append("-1").append("\n");
      return;
    }
    sb.append(deque.peekFirst()).append("\n");
  }

  static void getBack() {
    if (deque.isEmpty()) {
      sb.append("-1").append("\n");
      return;
    }
    sb.append(deque.peekLast()).append("\n");
  }
}
