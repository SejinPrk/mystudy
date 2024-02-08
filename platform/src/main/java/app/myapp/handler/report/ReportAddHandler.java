package app.myapp.handler.report;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.ReportDao;
import app.myapp.vo.Notification;
import app.util.Prompt;
import java.util.Date;

public class ReportAddHandler extends AbstractMenuHandler {

  private ReportDao boardDao;

  public ReportAddHandler(ReportDao boardDao, Prompt prompt) {
    super(prompt);
    this.boardDao = boardDao;
  }

  @Override
  protected void action() {
    Notification board = new Notification();
    board.setTitle(this.prompt.input("제목? "));
    board.setContent(this.prompt.input("내용? "));
    board.setWriter(this.prompt.input("작성자? "));
    board.setCreatedDate(new Date());

    boardDao.add(board);
  }
}
