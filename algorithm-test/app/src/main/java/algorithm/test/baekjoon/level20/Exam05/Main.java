package algorithm.test.baekjoon.level20.Exam05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 4779 칸토어 집합
public class Main {
  static int N;
  static StringBuilder ans;
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str;

    while ((str = br.readLine()) != null) {
      N = Integer.parseInt(str);
      ans = new StringBuilder();
      int len = (int) Math.pow(3,N);

      for (int i = 0; i < len; i++) {
        ans.append("-");
      }
      func(0, len);
      System.out.println(ans);
    }
  }

  public static void func(int start, int size) {
    if (size == 1) {
      return;
    }
    int newSize = size / 3;

    for (int i = start + newSize; i < start + 2 * newSize; i++) {
      ans.setCharAt(i, ' ');
    }

    func(start, newSize);
    func(start + 2 * newSize, newSize);
  }
}
