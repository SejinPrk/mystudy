package algorithm.test.baekjoon.level15.Exam09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 13909 창문 닫기
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int cnt = 0;
    for (int i = 1; i * i <= N; i++) {
      cnt++;
    }

    bw.write(cnt + "\n");
    br.close();

    bw.flush();
    bw.close();
  }
}
