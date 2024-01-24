package algorithm.test.baekjoon.level11.Exam06;
// 24267 알고리즘 수업-알고리즘의 수행 시간 6
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long n = Long.parseLong(br.readLine());

    System.out.println(n*(n-1)*(n-2)/6);
    System.out.println(3);

    br.close();
  }
}
