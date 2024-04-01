package algorithm.test.baekjoon.level22.Exam03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 16139 인간 - 컴퓨터 상호작용
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = br.readLine();
    int q = Integer.parseInt(br.readLine());
    int l = s.length();

    int[][] record = new int[l+1][26];
    record[1][s.charAt(0)-'a']++;

    for (int i = 2; i <= l; i++) {
      int index = s.charAt(i-1)-'a';

      for (int j = 0; j < 26; j++) {
        int before = record[i-1][j];
        record[i][j] = j == index? before+1 : before;
      }
    }

    StringTokenizer st;
    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int index = st.nextToken().charAt(0)-'a';
      int start = Integer.parseInt(st.nextToken()) + 1;
      int end = Integer.parseInt(st.nextToken()) +1;

      bw.append(record[end][index] - record[start-1][index] + "\n");
    }
    bw.close();
    br.close();
  }
}
