package algorithm.test.baekjoon.level03.exam12;

import java.util.Scanner;

// A+B -4
// EoF: End of File
// hasNext()메서드는 Boolean 값을 통해 다음 줄이 없으면 false을 반환하고 끝을 알려준다.
public class Main {
  public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

      while(sc.hasNextInt()) {
          int A = sc.nextInt();
          int B = sc. nextInt();
          System.out.println(A+B);
        }
        sc.close();
      }
    }

