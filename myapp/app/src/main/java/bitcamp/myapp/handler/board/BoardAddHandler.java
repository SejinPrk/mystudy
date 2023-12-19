package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import java.util.ArrayList;

public class BoardAddHandler extends AbstractMenuHandler {

  private Prompt prompt;
  private ArrayList<Board> objectRepository;

  public BoardAddHandler(ArrayList<Board> objectRepository, Prompt prompt) {
    this.objectRepository = objectRepository;
    this.prompt = prompt;
  }

  @Override
  public void action() {
    // MenuHandler 인터페이스에 선언된 메서드 대신
    // AbstractMenuHandler에 추가된 action()추상 메서드를 구현한다.
    Board board = new Board();
    board.setTitle(this.prompt.input("제목? "));
    board.setContent(this.prompt.input("내용? "));
    board.setWriter(this.prompt.input("작성자? "));
    board.setCreatedDate(this.prompt.input("작성일? "));

    objectRepository.add(board);
  }
}
