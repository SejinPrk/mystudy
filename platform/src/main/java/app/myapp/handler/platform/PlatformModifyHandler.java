package app.myapp.handler.platform;

import app.menu.AbstractMenuHandler;
import app.myapp.dao.PlatformDao;
import app.myapp.vo.Platform;
import app.util.Prompt;

public class PlatformModifyHandler extends AbstractMenuHandler {

  private PlatformDao platformDao;

  public PlatformModifyHandler(PlatformDao platformDao, Prompt prompt) {
    super(prompt);
    this.platformDao = platformDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("번호? ");

      Platform old = PlatformDao.findBy(no);
      if (old == null) {
        System.out.println("플랫폼 번호가 유효하지 않습니다!");
        return;
      }

      Platform platform = new Platform();
      platform.setNo(old.getNo());
      platform.setName(this.prompt.input("플랫폼명(%s): ", old.getName()));
      platform.setPrice(this.prompt.input("구독료(%s): ", old.getPrice()));
      platform.setTerm(this.prompt.input("결제주기(%s): ", old.getTerm()));

      platformDao.update(platform);
      System.out.println("과제를 변경했습니다.");

    } catch (NumberFormatException e) {
      System.out.println("숫자를 입력하세요!");

    } catch (IllegalArgumentException e) {
      System.out.println("과제 변경 오류!");
      System.out.println("다시 시도 하세요.");

    } catch (Exception e) {
      System.out.println("실행 오류!");
      e.printStackTrace();
    }

  }
}
