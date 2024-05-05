package algorithm.test.baekjoon.level28.Exam05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 3015 오아시스 재결합
public class Main {
  static int N;
  static Stack<Pair> stack = new Stack<>();
  static long cnt;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      int n = Integer.parseInt(br.readLine());
      Pair pair = new Pair(n, 1);
    }
  }
}
