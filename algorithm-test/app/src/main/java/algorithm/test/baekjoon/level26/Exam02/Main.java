package algorithm.test.baekjoon.level26.Exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 1927 최소 힙
public class Main {

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      PriorityQueue<Integer> queue = new PriorityQueue<>();

      for (int i = 0; i < n; i++) {
        int num = Integer.parseInt(br.readLine());
        if (num == 0) {
          if (!queue.isEmpty())
            System.out.println(queue.poll());
          else
            System.out.println(0);
          continue;
        }
          queue.add(num);
      }
    }
}
