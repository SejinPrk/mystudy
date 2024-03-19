package algorithm.test.baekjoon.level14.Exam01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    HashMap<String, Integer> have = new HashMap<>();

    int n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i =0; i < n; i++) {
      have.put(st.nextToken(), 0);
    }
    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++ ){
      if (have.get(st.nextToken())!= null) {
        sb.append("1 ");
      } else {
        sb.append("0 ");
      }
    }
    System.out.println(sb.toString());
  }
}
