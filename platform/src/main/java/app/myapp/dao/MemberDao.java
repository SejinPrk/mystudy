package app.myapp.dao;

import app.myapp.vo.Member;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberDao {

  void add(Member member);

  int delete(int no);

  List<Member> findAll(
      @Param("offset") int offset,
      @Param("rowCount") int rowCount
  );

  Member findBy(int no);

  int update(Member member);

  Member findByEmailAndPassword(
      @Param("email") String email,
      @Param("password") String password);

  int countAll();
}
