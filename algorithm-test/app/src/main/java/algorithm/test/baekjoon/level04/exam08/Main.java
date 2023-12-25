package algorithm.test.baekjoon.level04.exam08;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

// 3052 나머지
public class Main {
 public static void main(String[] args){
   Scanner sc = new Scanner(System.in);
   HashSet<Integer> h = new HashSet<Integer>();

   for (int i =0; i<10; i++){
     h.add(sc.nextInt()% 42);
   }
   sc.close();
   System.out.println(h.size());
 }
}
