package app.myapp.dao;

import app.myapp.vo.Assignment;
import java.util.List;

public interface AssignmentDao {

  void add(Assignment assignment);

  int delete(int no);

  List<Assignment> findAll();

  Assignment findBy(int no);

  int update(Assignment assignment);

}
