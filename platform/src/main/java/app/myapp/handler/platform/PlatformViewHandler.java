package app.myapp.handler.platform;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.PlatformDao;
import app.myapp.vo.Platform;
import app.util.Prompt;

public class PlatformViewHandler extends AbstractMenuHandler {

  private PlatformDao platformDao;

  public PlatformViewHandler(PlatformDao platformDao, Prompt prompt) {
    super(prompt);
    this.platformDao = platformDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("번호? ");
      Platform platform = platformDao.findBy(no);
      if (platform == null) {
        System.out.println("플랫폼 번호가 유효하지 않습니다!");
        return;
      }

      System.out.printf("번호: %s\n", platform.getNo());
      System.out.printf("플랫폼명: %s\n", platform.getName());
      System.out.printf("가격: %s\n", platform.getTerm());
      System.out.printf("결젝주기: %s\n", platform.getTerm());

    } catch (Exception e) {
      System.out.println("조회 오류!");
    }
  }

}
