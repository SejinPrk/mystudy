package app.myapp.handler.report;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.BoardDao;
import app.myapp.vo.Report;
import app.util.Prompt;
import java.util.Date;

public class BoardAddHandler extends AbstractMenuHandler {

  private BoardDao boardDao;

  public BoardAddHandler(BoardDao boardDao, Prompt prompt) {
    super(prompt);
    this.boardDao = boardDao;
  }

  @Override
  protected void action() {
    Report board = new Report();
    board.setTitle(this.prompt.input("제목? "));
    board.setContent(this.prompt.input("내용? "));
    board.setWriter(this.prompt.input("작성자? "));
    board.setCreatedDate(new Date());

    boardDao.add(board);
  }
}
