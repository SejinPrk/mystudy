package bitcamp.util;

public class ObjectRepository {

  // 수퍼 클래스의 레퍼런스는 서브 클래스의 인스턴스 주소를 담을 수 있다.
// 따라서 Object 레퍼런스는 Member, Board, Assignment 등 어떤 주소라도 담을 수 있다 .
  private Object[] objects = new Object[3];
  private int length = 0;

  // 대신 목록에 값을 추가하거나, 꺼내거나 삭제하려면
  // 메서드를 통해 수행하도록 유도한다.
  //  => 캡슐화한다.

  public void add(Object object) {
    if (this.length == this.objects.length) {
      int oldSize = this.objects.length;
      int newSize = oldSize + (oldSize >> 1);

      Object[] arr = new Object[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.objects[i];
      }

      this.objects = arr;
    }
    this.objects[this.length++] = object;

  }

  public Object remove(int index) {
    if (index < 0 || index >= this.length) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return null;
    }

    // 배열에서 삭제하기 전에 임시 보관해 둔다.
    Object deleted = this.objects[index];

    for (int i = index; i < (this.length - 1); i++) {
      this.objects[i] = this.objects[i + 1];
    }
    this.objects[--this.length] = null;

    // 삭제한 객체를 리턴한다.
    // 받아서 쓰든가 말든가 호출하는 쪽에서 알아서 할 일이다.
    return deleted;
  }

  public Object[] toArray() {
    Object[] arr = new Object[this.length];
    for (int i = 0; i < this.length; i++) {
      arr[i] = this.objects[i];
    }
    return arr;
  }

  public Object get(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }
    return this.objects[index];
  }

  public Object set(int index, Object object) {
    if (index < 0 || index >= this.length) {
      return null;
    }
    Object old = this.objects[index];
    this.objects[index] = object;

    // 새 객체로 교체하기 전에 이전 객체를 리턴한다.
    // 호출하는 쪽에서 받아 쓰거나 말거나 알아서 하라고!
    return old;
  }
}
