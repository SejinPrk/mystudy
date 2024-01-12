package algorithm.test.baekjoon.level08.exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2720 세탁소 사장 동혁
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
    int quarter = 25;
    int dime = 10;
    int nickel = 5;
    int penny = 1;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < num; i++){
      int change = Integer.parseInt(br.readLine());
      sb.append(change / quarter + " ");
      change %= quarter;
      sb.append(change / dime + " ");
      change %= dime;
      sb.append(change / nickel + " ");
      change %= nickel;
      sb.append(change / penny + "\n");
    }
    System.out.print(sb);
  }
}
