package algorithm.test.baekjoon.level14.Exam06;
// 1427 소트 인사이드

import java.io.IOException;
import java.io.InputStream;

public class Main {
  public static void main(String[] args) throws IOException {
    InputStream in = System.in;

    int[] counting = new int[10];
    int c;
    while((c=in.read()) != '\n'){
      counting[c-'0']++;
    }

    for (int i = 9; i >= 0; i--) {
      while(counting[i]-- > 0){
        System.out.print(i);
      }
    }
  }
}
