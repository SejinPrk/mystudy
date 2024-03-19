package algorithm.test.baekjoon.level13.Exam01;

// 2750 수 정렬하기
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i< n; i++){
      arr[i] = sc.nextInt();
    }
    Arrays.sort(arr);

    for (int val : arr){
      System.out.println(val);
    }
  }

}
