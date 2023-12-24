package algorithm.test.baekjoon.level04.exam07;

import java.util.Scanner;

// 5597 과제 안내신 분..?
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int [] student = new int[30];

    for(int i=0; i<28; i++){
      int submitted = sc.nextInt();
      student[submitted-1] = 1;
    }
    for (int i=0; i<student.length; i++){
      if(student[i]== 0)
        System.out.println(i+1);
    }
    sc.close();
  }
}
