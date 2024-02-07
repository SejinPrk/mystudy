package algorithm.test.baekjoon.level15.Exam04;
// 1620 나는야 포켓몬 마스터 이다솜

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    HashMap<String, Integer> hm = new HashMap<>();
    String[] arr = new String[n + 1];
    for (int i = 1; i <= n; i++) {
      String s = br.readLine();
      hm.put(s, i);
      arr[i] = s;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      String s = br.readLine();
      if (Character.isDigit(s.charAt(0))) {
        sb.append(arr[Integer.parseInt(s)]);
      } else {
        sb.append(hm.get(s));
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}