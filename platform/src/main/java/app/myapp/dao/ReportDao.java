package app.myapp.dao;

import app.myapp.vo.Report;
import java.util.List;

public interface ReportDao {

  void add(Report report);

  int delete(int no);

  List<Report> findAll();

  Report findBy(int no);

  int update(Report report);

}
