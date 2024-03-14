package algorithm.test.baekjoon.level19.Exam02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

// 25192 인사성 밝은 곰곰이
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    HashSet enter = new HashSet();

    int N = Integer.parseInt(br.readLine());
    int cnt = 0;

    for (int i = 0; i < N; i++) {
      String chat = br.readLine();
      if (chat.equals("ENTER")) {
        cnt += enter.size();
        enter = new HashSet();
      } else {
        enter.add(chat);
      }
    }
    cnt += enter.size();

    bw.write(cnt + "\n");
    br.close();
    bw.flush();
    bw.close();
  }
}