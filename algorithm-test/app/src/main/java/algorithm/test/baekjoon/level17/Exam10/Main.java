package algorithm.test.baekjoon.level17.Exam10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 2346 풍선 터뜨리기
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    Deque<Balloon> queue = new ArrayDeque<>();

    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] balloon = new int[N];
    for (int i = 0; i < N; i++) {
      balloon[i] = Integer.parseInt(st.nextToken());
    }
    br.close();
    sb.append("1 ");
    int move = balloon[0];

    for (int i = 1; i < N; i++) {
      queue.add(new Balloon(i+1, balloon[i]));
    }

    while (! queue.isEmpty()) {
      if (move > 0) {
        for (int i = 1; i < move; i++) {
          queue.add(queue.poll());
        }
        Balloon next = queue.poll();
        move = next.numValue;
        sb.append(next.index + " ");
      } else {
        for (int i = 1; i < -move; i++) {
          queue.addFirst(queue.pollLast());
        }
        Balloon next = queue.pollLast();
        move = next.numValue;
        sb.append(next.index + " ");
      }
    }
    System.out.println(sb);
  }
}

class Balloon{
  int index;
  int numValue;

  public Balloon(int index, int numValue) {
    this.index = index;
    this.numValue = numValue;
  }
}
