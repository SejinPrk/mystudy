package algorithm.test.baekjoon.level15.Exam08;

// 17103 골드바흐 파티션
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    boolean[] check = new boolean[1000001];
    check[0] = true;
    check[1] = true;
    for (int i = 2; i <= Math.sqrt(1000000); i++) {
      if (check[i]) continue;
      for (int j = i*i; j < 1000001; j+=i) {
        check[j] = true;
      }
    }

    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      int cnt = 0;
      int tmp = sc.nextInt();
      for (int j = 2; j <= tmp/2; j++) {
        if (!check[j] && !check[tmp-j])
          cnt++;
      }
      System.out.println(cnt);
    }
  }
}