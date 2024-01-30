package algorithm.test.baekjoon.level14.Exam06;
// 1427 소트 인사이드

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    char[] arr = br.readLine().toCharArray();

    Arrays.sort(arr);

    for (int i = arr.length-1; i >= 0; i--) {
      System.out.println(arr[i]);
    }
  }
}
