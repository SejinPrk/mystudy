package algorithm.test.baekjoon.level13.Exam01;

import java.util.Scanner;

// 2708 블랙잭
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int sum = 0;
    int temp = 0;

    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    for (int i = 0; i<n; i++){
      for (int j = i+1; j<n; j++){
        for(int k = j+1; k < n; k++){
          sum = arr[i] + arr[j] + arr[k];
          if(temp < sum && sum <= m){
            temp = sum;
          }
        }
      }
    }
    System.out.println(temp);
  }
}
