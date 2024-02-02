package book.myapp.dao;

import book.myapp.vo.Member;
import java.util.List;

public interface MemberDao {

  void add(Member member);

  int delete(int no);

  List<Member> findAll();

  Member findBy(int no);

  int update(Member member);

  ;
}
