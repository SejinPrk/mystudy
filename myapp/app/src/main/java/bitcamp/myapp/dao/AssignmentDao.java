package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Assignment;
import bitcamp.myapp.vo.AttachedFile;
import java.util.List;

public interface AssignmentDao {

  void add(Assignment assignment);

  int delete(int no);

  List<Assignment> findAll();

  Assignment findBy(int no);

  int update(Assignment assignment);

}
