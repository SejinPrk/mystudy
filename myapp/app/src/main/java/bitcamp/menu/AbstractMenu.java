package bitcamp.menu;

import bitcamp.util.Stack;

public abstract class AbstractMenu implements Menu {

  protected Stack<String> breadcrumb;
  String title;
  public AbstractMenu(String title, Stack<String> breadcrumb) {
    this.title = title;
    this.breadcrumb = breadcrumb;
  }

  @Override
  public String getTitle() {
    return breadcrumb.peek();
  }

  public String getMenuPath(){
    return String.join("/", breadcrumb.toArray(new String[0])); // 배열의 값 중간에 슬래시를 하나씩 넣어준다.
  }
}
