package app.myapp.handler.report;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.ReportDao;
import app.myapp.vo.Notification;
import app.util.Prompt;

public class ReportModifyHandler extends AbstractMenuHandler {

  private ReportDao reportDao;

  public ReportModifyHandler(ReportDao reportDao, Prompt prompt) {
    super(prompt);
    this.reportDao = reportDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Notification oldBoard = reportDao.findBy(no);
    if (reportDao == null) {
      System.out.println("리포트 번호가 유효하지 않습니다.");
      return;
    }

    Notification board = new Notification();
    board.setNo(oldBoard.getNo()); // 기존 게시글의 번호를 그대로 설정한다.
    board.setTitle(this.prompt.input("제목(%s)? ", oldBoard.getTitle()));
    board.setContent(this.prompt.input("내용(%s)? ", oldBoard.getContent()));
    board.setWriter(this.prompt.input("작성자(%s)? ", oldBoard.getWriter()));
    board.setCreatedDate(oldBoard.getCreatedDate());

    boardDao.update(board);
    System.out.println("게시글을 변경했습니다.");
  }
}
