package algorithm.test.baekjoon.level07.exam04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2563 색종이
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int black = 0;
    int n = Integer.parseInt(br.readLine());
    boolean[][] arr = new boolean[100][100];

    for(int i =0; i<n; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      for (int j=x; j < x+10; j++){
        for(int k=y; k < y+10; k++){
          if(!arr[j][k]){
            arr[j][k] = true;
            black++;
          }
        }
      }
    }
    System.out.println(black);
  }
}
