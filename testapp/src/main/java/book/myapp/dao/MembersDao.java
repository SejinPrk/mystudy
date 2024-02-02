package book.myapp.dao;

import book.myapp.vo.Members;
import java.util.List;

public interface MembersDao {

  public void add(Members members);

  public int delete(int no);

  public List<Members> findAll();

  public Members findBy(int no);

  public int update(Members members);

  ;
}
