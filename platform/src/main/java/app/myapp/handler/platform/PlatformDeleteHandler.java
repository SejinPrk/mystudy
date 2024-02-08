package app.myapp.handler.platform;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.PlatformDao;
import app.util.Prompt;

public class PlatformDeleteHandler extends AbstractMenuHandler {

  private PlatformDao platformDao;

  public PlatformDeleteHandler(PlatformDao platformDao, Prompt prompt) {
    super(prompt);
    this.platformDao= platformDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("번호? ");
      if (platformDao.delete(no) == 0) {
        System.out.println("플랫폼 번호가 유효하지 않습니다!");
      } else {
        System.out.println("플랫폼을 삭제했습니다.");
      }

    } catch (Exception e) {
      System.out.println("삭제 오류!");
    }
  }
}
