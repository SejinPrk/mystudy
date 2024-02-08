package app.myapp.handler.platform;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.PlatformDao;
import app.myapp.vo.Assignment;
import app.util.Prompt;
import java.util.List;

public class PlatformListHandler extends AbstractMenuHandler {

  private PlatformDao assignmentDao;

  public PlatformListHandler(PlatformDao assignmentDao, Prompt prompt) {
    super(prompt);
    this.assignmentDao = assignmentDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-20s\t%s\n", "번호", "과제", "제출마감일");

    List<Assignment> list = assignmentDao.findAll();

    for (Assignment assignment : list) {
      System.out.printf("%-4d\t%-20s\t%s\n",
          assignment.getNo(),
          assignment.getTitle(),
          assignment.getDeadline());
    }
  }
}