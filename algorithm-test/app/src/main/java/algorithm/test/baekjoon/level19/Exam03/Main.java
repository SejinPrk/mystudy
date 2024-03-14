package algorithm.test.baekjoon.level19.Exam03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

// 26069 붙임성 좋은 총총이
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st;
    String A, B;

    HashSet<String> enter = new HashSet();
    enter.add("ChongChong");

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      A = st.nextToken();
      B = st.nextToken();
      if (enter.contains(A) || enter.contains(B)) {
        enter.add(A);
        enter.add(B);
      }
    }
    br.close();

    bw.write(enter.size() + "\n");
    bw.flush();
    bw.close();
  }

}
