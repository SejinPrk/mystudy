package app.myapp.handler.report;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.ReportDao;
import app.util.Prompt;

public class BoardDeleteHandler extends AbstractMenuHandler {

  private ReportDao boardDao;

  public BoardDeleteHandler(ReportDao boardDao, Prompt prompt) {
    super(prompt);
    this.boardDao = boardDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");
    if (boardDao.delete(no) == 0) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
    } else {
      System.out.println("삭제했습니다!");
    }
  }
}
