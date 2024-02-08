package app.myapp.handler.method;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.ReportDao;
import app.myapp.vo.Report;
import app.util.Prompt;

public class BoardViewHandler extends AbstractMenuHandler {

  private ReportDao boardDao;

  public BoardViewHandler(ReportDao boardDao, Prompt prompt) {
    super(prompt);
    this.boardDao = boardDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Report board = boardDao.findBy(no);
    if (board == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("내용: %s\n", board.getContent());
    System.out.printf("작성자: %s\n", board.getWriter());
    System.out.printf("작성일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", board.getCreatedDate());
  }
}
