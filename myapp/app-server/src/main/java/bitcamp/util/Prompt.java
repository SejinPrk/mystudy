package bitcamp.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;
import java.util.Scanner;

public class Prompt implements AutoCloseable {

  Scanner keyIn;
  private DataInputStream in;
  private DataOutputStream out;
  private StringWriter stringWriter = new StringWriter();
  private PrintWriter writer = new PrintWriter(stringWriter);
  public Prompt (InputStream in) { keyIn = new Scanner(in); }
  public Prompt(DataInputStream in, DataOutputStream out) {
    this.in = in;
    this.out = out;
  }

  public String input(String str,Object... args) {
    try {
      printf(str, args);
      end();
      return input();
    } catch (Exception e){
      throw new RuntimeException(e);
    }
  }

  public int inputInt(String str,Object... args) {
    return Integer.parseInt(this.input(str, args));
  }

  public float inputFloat(String str,Object... args) {
    return Float.parseFloat(this.input(str, args));
  }

  public boolean inputBoolean(String str,Object... args) {
    return Boolean.parseBoolean(this.input(str, args));
  }

  public Date inputDate(String str,Object... args) { return Date.valueOf(this.input(str, args)); }

  //-----------------------------------------------------

  public void print(String str){
    writer.print(str);
  }
  public void println(String str) {
    writer.println(str);
  }

  public void printf(String str, Object... args){
    writer.printf(str, args);
  }

  public void end() throws Exception {
    // PrintWriter 를 통해 출력한 내용은 StringWriter 에 쌓여있다.
    // StringWriter 에 쌓여있는 문자열을 꺼낸다.
    StringBuffer buf = stringWriter.getBuffer();
    String content = buf.toString();

    // StringWriter 에 쌓여있는 문자열을 꺼낸 후 버퍼를 다시 0으로 초기화시킨다.
    buf.setLength(0);

    // Buffer 에서 꺼낸 문자열을 클라이언트로 전송한다.
    // 즉 서버의 응답이 완료된다.
    out.writeUTF(content);
  }
  public String input() throws Exception {
    return in.readUTF();
  }

  public int inputInt() throws Exception {
    return Integer.parseInt(this.input());
  }

  public float inputFloat() throws Exception {
    return Float.parseFloat(this.input());
  }

  public boolean inputBoolean() throws Exception {
    return Boolean.parseBoolean(this.input());
  }

  public Date inputDate() throws Exception {
    return Date.valueOf(this.input());
  }

  public void close() throws Exception {
    writer.close();
    stringWriter.close();
  }
}