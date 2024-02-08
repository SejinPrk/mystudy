package app.myapp.handler.method;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.ReportDao;
import app.myapp.vo.Notification;
import app.util.Prompt;
import java.util.List;

public class BoardListHandler extends AbstractMenuHandler {

  private ReportDao boardDao;

  public BoardListHandler(ReportDao boardDao, Prompt prompt) {
    super(prompt);
    this.boardDao = boardDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-20s\t%10s\t%s\n", "No", "Title", "Writer", "Date");

    List<Notification> list = boardDao.findAll();

    for (Notification board : list) {
      System.out.printf("%-4d\t%-20s\t%10s\t%4$tY-%4$tm-%4$td\n",
          board.getNo(),
          board.getTitle(),
          board.getWriter(),
          board.getCreatedDate());
    }
  }
}
