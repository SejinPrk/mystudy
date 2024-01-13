package algorithm.test.baekjoon.level08.exam04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2903 중앙 이동 알고리즘
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    br.close();

    System.out.println((int)Math.pow(Math.pow(2, n) +1, 2));
  }
}
