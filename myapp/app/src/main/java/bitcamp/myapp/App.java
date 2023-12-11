package bitcamp.myapp;

import bitcamp.myapp.menu.MainMenu;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) {
    // Socket socket = new Socket("192.154.33.55", 8988);
    Prompt prompt = new Prompt(System.in);
    MainMenu mainMenu = new MainMenu(prompt);
    mainMenu.execute();
    prompt.close();
  }
}
