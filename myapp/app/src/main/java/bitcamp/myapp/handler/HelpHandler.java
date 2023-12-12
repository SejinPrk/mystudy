package bitcamp.myapp.handler;

import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;

public class HelpHandler implements MenuHandler {

  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

  }
}
