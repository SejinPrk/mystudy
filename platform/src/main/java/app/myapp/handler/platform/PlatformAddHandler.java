package app.myapp.handler.platform;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.PlatformDao;
import app.myapp.vo.Platform;
import app.util.Prompt;

public class PlatformAddHandler extends AbstractMenuHandler {

  private PlatformDao platformDao;


  public PlatformAddHandler(PlatformDao platformDao, Prompt prompt) {
    super(prompt);
    this.platformDao = platformDao;
  }

  @Override
  protected void action() {
    try {
      Platform platform = new Platform();
      platform.setName(this.prompt.input("플랫폼명: "));
      platform.setPrice(this.prompt.input("구독료: "));
      platform.setTerm(this.prompt.input("결제주기: "));

      platformDao.add(platform);

    } catch (Exception e) {
      System.out.println("과제 입력 중 오류 발생!");
      System.out.println("다시 시도하시기 바랍니다.");
    }
  }
}
