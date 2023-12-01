public class myProject {
  static final String ANSI_CLEAR = "\033[0m";
  static final String ANSI_BOLD_RED = "\033[1;31m";
  static final String ANSI_RED = "\033[0;31m";
  static final String APP_TITLE = ANSI_BOLD_RED + "[출결관리 시스템]" + ANSI_CLEAR;
  static final String[] MENUS = {
      "1. 출석",
      "2. 지각",
      "3. 조퇴",
      ANSI_RED + "4. 퇴근" + ANSI_CLEAR


}
  public static void main(String[] args){

    java.util.Scanner keyIn = new java.util.Scanner(System.in);

}