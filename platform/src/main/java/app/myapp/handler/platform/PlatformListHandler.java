package app.myapp.handler.platform;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.PlatformDao;
import app.myapp.vo.Platform;
import app.util.Prompt;
import java.util.List;

public class PlatformListHandler extends AbstractMenuHandler {

  private PlatformDao platformDao;

  public PlatformListHandler(PlatformDao platformDao,Prompt prompt) {
    super(prompt);
    this.platformDao = platformDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-20s\t%-20s\t%s\n", "번호", "플랫폼명", "구독료", "결제주기");

    List<Platform> list = platformDao.findAll();

    for (Platform platform : list) {
      System.out.printf("%-4s\t%-20s\t%-20s\t%s\n",
          platform.getNo(),
          platform.getName(),
          platform.getPrice(),
          platform.getTerm());
    }
  }
}
