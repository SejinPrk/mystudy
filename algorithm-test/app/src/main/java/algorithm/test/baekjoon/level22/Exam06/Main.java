package algorithm.test.baekjoon.level22.Exam06;

//25682 체스판 다시 칠하기 2
import java.io.*;
import java.util.*;


public class Main {
  static int N, M, K, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
  static int[][] board;	//M×N배열에 색칠 관련 배열
  public static void main(String[] args) throws IOException {
    //입력값 처리하는 BufferedReader
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //결과값 출력하는 BufferedWriter
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    board = new int[N+1][M+1];
    //false : 검은색, true : 흰색
    //첫 칸은 검은색으로 설정.
    boolean color = false;
    //첫 칸이 검은색일 때 칠하는 경우 저장
    for(int i=1;i<=N;i++){
      String str = br.readLine();
      for(int j=1;j<=M;j++){
        char c = str.charAt(j-1);
        if(!color && c == 'W')	//검은색으로 색 변경
          board[i][j] = 1;
        else if(color && c == 'B')	//흰색으로 색 변경
          board[i][j] = 1;
        color = !color;
      }
      if(M % 2 == 0)
        color = !color;
    }
    //누적합, 행 더하기.
    for(int i=1;i<=N;i++){
      int temp = board[i][1];
      for(int j=2;j<=M;j++){
        temp += board[i][j];
        board[i][j] = temp;
      }
    }
    //누적합, 열 더하기.
    for(int i=1;i<=M;i++){
      int temp = board[1][i];
      for(int j=2;j<=N;j++){
        temp += board[j][i];
        board[j][i] = temp;
      }
    }
    //K×K 정사각형 자르는 모든 경우 탐색
    for(int i=K;i<=N;i++){
      for(int j=K;j<=M;j++){
        //점화식을 이용한 해당 합 구하기
        int temp = board[i][j] - (board[i-K][j] + board[i][j-K] - board[i-K][j-K]);
        min = Math.min(min, temp);	//최소값 비교하기
        max = Math.max(max, temp);	//최대값 비교하기
      }
    }
    //시작이 검은색일 때 : min
    //시작이 흰색일 때 : K*K - max
    int answer = Math.min(min, K*K - max);	//최소 횟수 구하기
    bw.write(answer + "");	//최소 횟수 BufferedWriter 저장
    bw.flush();		//결과 출력
    bw.close();
    br.close();
  }
}
