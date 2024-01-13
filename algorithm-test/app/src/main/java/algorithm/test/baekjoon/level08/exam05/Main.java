package algorithm.test.baekjoon.level08.exam05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2292 벌집
public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int cnt = 1;
    int range = 2;

    if(N==1){
      System.out.print(1);
    } else {
      while (range <= N){
        range = range + 6*cnt;
        cnt++;
      }
      System.out.print(cnt);
    }
  }
}
