package bitcamp.util;

public class ArrayListIterator<E> implements Iterator<E> {

  ArrayList<E> list;
  int cursor;

  public ArrayListIterator(ArrayList<E> list){
    this.list = list;
  }

@Override
 public boolean hasNext(){
   return cursor >= 0 && cursor < list.size();
 }

 @Override
 public E next(){
   return list.get(cursor++); //커서를 꺼내고 난 다음에는 항상 증가시킨다.
 }
}
