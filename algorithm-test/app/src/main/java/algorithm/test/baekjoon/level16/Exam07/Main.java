package algorithm.test.baekjoon.level16.Exam07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 2164 카드2
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Queue<Integer> q = new LinkedList<>();

    int N = sc.nextInt();
    for (int i = 1; i <= N; i++) {
      q.offer(i);
    }

    while(q.size() > 1) {
      q.poll();
      q.offer(q.poll());
    }
    System.out.println(q.poll());
  }
}
