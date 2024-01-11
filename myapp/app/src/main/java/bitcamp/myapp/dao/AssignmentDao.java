package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Assignment;
import java.util.List;

public class AssignmentDao extends AbstractDao<Assignment> {

  private int lastKey;

  public AssignmentDao(String filepath) {
    super(filepath);
    lastKey = list.getLast().getNo();
  }

  public void add(Assignment assignment) {
    assignment.setNo(++lastKey);
    this.list.add(assignment);
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


  public List<Assignment> findAll() {
    return this.list.subList(0, list.size());
  }

  public Assignment findBy(int no) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == no) {
        return list.get(i);
      }
    }
    return null;
  }

  public int update(int no, Assignment assignment) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == no) {
        list.set(i, assignment);
        saveData();
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