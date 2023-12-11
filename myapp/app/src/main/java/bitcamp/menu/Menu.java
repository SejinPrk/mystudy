package bitcamp.menu;

import bitcamp.util.Prompt;

// Menu를 처리하는 객체의 사용법을 정의한다.
public interface Menu {

  // 객체를 실행할 때 호출할 메서드를 선언한다.
  // 구현을 해서는 안된다. 중괄호 {} 안됨.
  // => 추상 메서드 (abstract)
  public abstract void execute(Prompt prompt); // public abstract는 기본 문법. 생략 가능!

  public abstract String getTitle(); // 메뉴에 제목을 리턴하는 메서드

}
