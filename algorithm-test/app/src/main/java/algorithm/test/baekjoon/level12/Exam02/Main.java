package algorithm.test.baekjoon.level12.Exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2231 분해합
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int ans = 0;


    for (int i = 1; i <= n; i++){
      int num = i;
      int sum = 0;

        while (num != 0){
          sum += num % 10;
          num /= 10;
        }

        if (sum + i == n){
          ans = i;
          break;
        }
    }
    System.out.println(ans);
  }
}
