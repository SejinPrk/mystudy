package algorithm.test.baekjoon.level15.Exam04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2485 가로수
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] tree = new int[n];

    for (int i = 0; i < n; i++) {
      tree[i] = Integer.parseInt(br.readLine());
    }
    br.close();

    int gcd = 0;
    for (int i = 0; i < n-1; i++) {
      int d = tree[i + 1] - tree[i];
      gcd = GCD(d, gcd);
    }
      bw.write((tree[n-1] - tree[0]) / gcd + 1 - (tree.length) + " ");
      bw.flush();
      bw.close();
    }

    static int GCD(int d, int gcd){
      while (gcd != 0) {
        int tmp = d % gcd;
        d = gcd;
        gcd = tmp;
      }
      return d;
    }
}