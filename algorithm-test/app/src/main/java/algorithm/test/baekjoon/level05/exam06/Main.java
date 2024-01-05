package algorithm.test.baekjoon.level05.exam06;
// 10809 알파벳 찾기
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String S = sc.nextLine();

    int[] arr = new int[26];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = -1;
    }

    for (int i = 0; i < S.length(); i++) {
      char ch = S.charAt(i);

      if (arr[ch - 'a'] == -1) {
        arr[ch - 'a'] = i;
      }
    }
    for(int val : arr){
      System.out.print(val + " ");
    }
  }
}