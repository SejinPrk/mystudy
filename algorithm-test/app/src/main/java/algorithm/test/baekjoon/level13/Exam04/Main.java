package algorithm.test.baekjoon.level13.Exam04;
// 2751 수 정렬하기 2

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

    public class Main {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++){
          list.add(sc.nextInt());
        }

        Collections.sort(list);

        for(int val : list) {
          sb.append(val).append('\n');
        }
        System.out.println(sb);
      }
    }

