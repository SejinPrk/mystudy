package algorithm.test.baekjoon.level06.exam04;

import java.util.Scanner;

// 10988 팰린드롬인지 확인하기
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    sc.close();
    int n = str.length();
    int a = 1; //true

    for(int i = 0; i<n/2; i++){
      if(str.charAt(i)!= str.charAt(n-1-i)){
        a = 0; // false
      }
    }
    System.out.println(a);
  }
}
