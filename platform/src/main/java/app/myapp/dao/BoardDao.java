package app.myapp.dao;

import app.myapp.vo.Report;
import java.util.List;

public interface BoardDao {

  void add(Report board);

  int delete(int no);

  List<Report> findAll();

  Report findBy(int no);

  int update(Report board);

}
