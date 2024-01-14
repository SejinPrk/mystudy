package algorithm.test.baekjoon.level08.exam06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1193 분수찾기
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(br.readLine());

    int cross = 1;
    int sum = 0;

    while(true){
      if(x <= sum + cross){
        if(cross %2 ==1){
          System.out.print(cross - (x-sum-1)+ "/"+ (x-sum));
          break;
        }
        else{
          System.out.print((x-sum) + "/"+ (cross-(x-sum-1)));
          break;
        }
      } else {
        sum += cross;
        cross++;
      }
    }
  }
}
