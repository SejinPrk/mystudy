package bitcamp.myapp.dao;


import bitcamp.myapp.vo.Member;
import java.util.List;

public class MemberDao extends AbstractDao<Member> {

  private int lastKey;

  public MemberDao(String filepath) {
    super(filepath);
    lastKey = list.getLast().getNo();
  }

  public void add(Member member) {
    member.setNo(++lastKey);
    this.list.add(member);
    saveData();
  }

  public int delete(int no) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == no) {
        list.remove(i);
        saveData();
        return 1;
      }
    }
    return 0;
  }


  public List<Member> findAll() {
    return this.list.subList(0, list.size());
  }

  public Member findBy(int no) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == no) {
        return list.get(i);
      }
    }
    return null;
  }

  public int update(int no, Member member) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == no) {
        list.set(i, member);
        return 1;
      }
    }
    return 0;
  }

  private int indexOf(int no) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}