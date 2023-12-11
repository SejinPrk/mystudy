package bitcamp.myapp;

import bitcamp.myapp.menu.MenuGroup;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) throws Exception {
    // Socket socket = new Socket("192.154.33.55", 8988);
    Prompt prompt = new Prompt(System.in);
    // new MainMenu(prompt).execute();

    MenuGroup mainMenu = new MenuGroup("메인");

    MenuGroup assignmentMenu = new MenuGroup("과제");
    mainMenu.add(assignmentMenu);

    MenuGroup boardMenu = new MenuGroup("게시글");
    mainMenu.add(boardMenu);

    MenuGroup memberMenu = new MenuGroup("회원");
    mainMenu.add(memberMenu);

    MenuGroup greetingMenu = new MenuGroup("가입인사");
    mainMenu.add(greetingMenu);

    MenuGroup helpMenu = new MenuGroup("도움말");
    mainMenu.add(helpMenu);

    mainMenu.execute(prompt);

    prompt.close();
  }
}
