package algorithm.test.baekjoon.level06.exam06;

import java.util.Scanner;

// 2941 크로아티아 알파벳
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    int count = 0;

    for (int i =0; i< str.length(); i++){
        char ch = str.charAt(i);

      if (ch == 'c') {
        if(i < str.length() -1){
          if (str.charAt(i+1) == '='){
            i++;
          } else if (str.charAt(i+1)== '-') {
            i++;
          }
          }
        } else if(ch == 'd'){
        if(i < str.length() -1){
          if(str.charAt(i+1) == 'z') {
            if (str.charAt(i + 1) == '=') {
              i += 2;
            }
          }
        } else if(str.charAt(i+1) == '-'){
            i++;
          }
      } else if(ch == 'l'){
        if(i < str.length() -1) {
          if (str.charAt(i + 1) == 'j') {
            i ++;
          }
        }
      } else if( ch == 'n'){
        if(i < str.length() -1) {
          if (str.charAt(i + 1) == 'j') {
            i++;
          }
        }
      } else if (ch == 's') {
        if(i < str.length() -1) {
          if (str.charAt(i + 1) == '=') {
            i++;
          }
        }
      } else if(ch == 'z'){
        if(i < str.length() -1){
          if(str.charAt(i+1) == '=') {
            i++;
          }
        }
      }
        count++;
    }
    System.out.println(count);

  }

}
