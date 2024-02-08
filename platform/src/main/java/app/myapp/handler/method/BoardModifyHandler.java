package app.myapp.handler.method;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.ReportDao;
import app.myapp.vo.Report;
import app.util.Prompt;

public class BoardModifyHandler extends AbstractMenuHandler {

  private ReportDao boardDao;

  public BoardModifyHandler(ReportDao boardDao, Prompt prompt) {
    super(prompt);
    this.boardDao = boardDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Report oldBoard = boardDao.findBy(no);
    if (oldBoard == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    Report board = new Report();
    board.setNo(oldBoard.getNo()); // 기존 게시글의 번호를 그대로 설정한다.
    board.setTitle(this.prompt.input("제목(%s)? ", oldBoard.getTitle()));
    board.setContent(this.prompt.input("내용(%s)? ", oldBoard.getContent()));
    board.setWriter(this.prompt.input("작성자(%s)? ", oldBoard.getWriter()));
    board.setCreatedDate(oldBoard.getCreatedDate());

    boardDao.update(board);
    System.out.println("게시글을 변경했습니다.");
  }
}
