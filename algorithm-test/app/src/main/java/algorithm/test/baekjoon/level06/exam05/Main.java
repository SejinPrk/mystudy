package algorithm.test.baekjoon.level06.exam05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1157 단어 공부
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[26];
    String s = br.readLine();

    for(int i = 0; i<s.length(); i++){
      if(65 <= s.charAt(i) && s.charAt(i) <= 90){
        arr[s.charAt(i)-65]++;
      }else{
        arr[s.charAt(i)-97]++;
      }
    }
    int max = -1;
    char ch = '?';

    for (int i =0; i<26; i++){
      if(arr[i] > max){
        max = arr[i];
        ch = (char)(i+65);
      }else if (arr[i]==max){
        ch = '?';
      }
    }
    System.out.println(ch);
  }

}
