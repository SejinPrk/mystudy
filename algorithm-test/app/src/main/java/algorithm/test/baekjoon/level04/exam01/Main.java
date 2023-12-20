package algorithm.test.baekjoon.level04.exam01;

import java.util.Scanner;

// 10807 개수 세기
public class Main {
 public static void main(String[] args){
   int count = 0;

   Scanner sc = new Scanner(System.in);
   int N = sc.nextInt();
   int [] arr = new int[N];

   for(int i=0; i< N; i++){
     arr[i] = sc.nextInt();
   }
   int b = sc.nextInt();

   for (int j=0; j<arr.length; j++){
     if(b==arr[j]){
       count++;
     }
   }
   System.out.println(count);
   sc.close();
 }
}
