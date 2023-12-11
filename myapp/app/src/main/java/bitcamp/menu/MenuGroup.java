package bitcamp.menu;

import bitcamp.util.Prompt;

// Composite 패턴에서 '복합 객체(Composite object)' 역할을 하는 클래스
// - 다른 Menu 객체를 포함한다.
public class MenuGroup implements Menu {

  String title;
  Menu[] menus = new Menu[10]; // 배열 생성
  int menuSize; // 현재 몇 개까지 저장?

  public MenuGroup(String title) {
    this.title = title;
  }

  @Override // 인터페이스나 수퍼 클래스의 메서드를 정의하겠다고 컴파일러에게 알린다.
  public void execute(Prompt prompt) {
    this.printMenu();

    while (true) {
      String input = prompt.input("%s> ", this.title);
      // 더 이상 인스턴스가 아니기 때문에 this.prompt가 아니다.

      if (input.equals("menu")) { // 조건문에서 문자열을 비교하는 방법. 동일하다면 equals가 true 출력.
        this.printMenu();
        continue;
      } else if (input.equals("0")) {
        break;
      }

      int menuNo = Integer.parseInt(input); // 정수로 바꾸기
      if (menuNo < 1 || menuNo > this.menuSize) {
        continue;
      }
      this.menus[menuNo - 1].execute(prompt); // 사용자는 1부터 번호를 입력하지만 배열은 0부터 시작하므로 -1
    }
  }

  private void printMenu() {
    //내부에서만 사용되는 메서드는 private
    System.out.printf("[%s]\n", this.title);

    for (int i = 0; i < this.menuSize; i++) {
      System.out.printf("%d. %s\n", (i + 1), menus[i].getTitle());
    }

    System.out.printf("0. %s\n", "이전");
  }

  @Override
  public String getTitle() {
    return this.title;
  }

  public void add(Menu menu) {
    if (this.menuSize == this.menus.length) {
      int oldSize = this.menus.length;
      int newSize = oldSize + (oldSize >> 1);

      Menu[] arr = new Menu[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.menus[i];
      }

      this.menus = arr;
    }
    this.menus[this.menuSize++] = menu;
  }

  public void remove(Menu menu) {
    int index = this.indexOf(menu);
    if (index == -1) {
      return;
    }

    for (int i = index; i < (this.menuSize - 1); i++) {
      this.menus[i] = this.menus[i + 1];
    }
    this.menus[--this.menuSize] = null;
  }

  int indexOf(Menu menu) {
    int index = -1;
    for (int i = 0; i < menuSize; i++) {
      if (menu == this.menus[i]) {
        return i;
      }
    }
    return -1;
  }
}

