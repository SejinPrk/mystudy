package app.myapp.dao;

import app.myapp.vo.Method;
import java.util.List;

public interface MethodDao {

  void add(Method method);

  int delete(int no);

  List<Method> findAll();

  Method findBy(int no);

  int update(Method method);

}
