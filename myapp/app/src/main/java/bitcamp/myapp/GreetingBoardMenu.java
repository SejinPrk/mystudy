package bitcamp.myapp;

public class GreetingBoardMenu {

  static GreetingBoard[] greetingboards = new GreetingBoard[3];
  static int length = 0;

  static void printMenu() {
    System.out.println("[가입인사]");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("5. 목록");
    System.out.println("0. 이전");
  }

  static void execute() {
    printMenu();
    while (true) {
      String input = Prompt.input("가입인사/게시글> ");

      switch (input) {
        case "1":
          add();
          break;
        case "2":
          view();
          break;
        case "3":
          modify();
          break;
        case "4":
          delete();
          break;
        case "5":
          list();
          break;
        case "0":
          return;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }
  }

  static void add() {
    System.out.println("가입인사 등록:");

    if (length == greetingboards.length) {
      int oldSize = greetingboards.length;
      int newSize = oldSize + (oldSize >> 1);

      GreetingBoard[] arr = new GreetingBoard[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = greetingboards[i];
      }

      greetingboards = arr;
    }

    GreetingBoard greetingBoard = new GreetingBoard();
    greetingBoard.title = Prompt.input("제목? ");
    greetingBoard.content = Prompt.input("내용? ");
    greetingBoard.writer = Prompt.input("작성자? ");
    greetingBoard.createdDate = Prompt.input("작성일? ");

    greetingboards[length++] = greetingBoard;
  }

  static void list() {
    System.out.println("가입인사 목록:");
    System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");

    for (int i = 0; i < length; i++) {
      GreetingBoard greetingBoard = greetingboards[i];
      System.out.printf("%-20s\t%10s\t%s\n", greetingBoard.title, greetingBoard.writer,
          greetingBoard.createdDate);
    }
  }

  static void view() {
    System.out.println("가입인사 조회:");

    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
      System.out.println("가입인사 번호가 유효하지 않습니다.");
      return;
    }

    GreetingBoard greetingBoard = greetingboards[index];
    System.out.printf("제목: %s\n", greetingBoard.title);
    System.out.printf("내용: %s\n", greetingBoard.content);
    System.out.printf("작성자: %s\n", greetingBoard.writer);
    System.out.printf("작성일: %s\n", greetingBoard.createdDate);
  }

  static void modify() {
    System.out.println("가입인사 변경:");

    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
      System.out.println("가입인사 번호가 유효하지 않습니다.");
      return;
    }

    GreetingBoard greetingBoard = greetingboards[index];
    greetingBoard.title = Prompt.input("제목(%s)? ", greetingBoard.title);
    greetingBoard.content = Prompt.input("내용(%s)? ", greetingBoard.content);
    greetingBoard.writer = Prompt.input("작성자(%s)? ", greetingBoard.writer);
    greetingBoard.createdDate = Prompt.input("작성일(%s)? ", greetingBoard.createdDate);
  }

  static void delete() {
    System.out.println("가입인사 삭제:");

    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
      System.out.println("가입인사 번호가 유효하지 않습니다.");
      return;
    }

    for (int i = index; i < (length - 1); i++) {
      greetingboards[i] = greetingboards[i + 1];
    }
    greetingboards[--length] = null;
  }
}
