package bitcamp.myapp.dao;

import bitcamp.myapp.vo.AttachedFile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public interface AttachedFileDao {

  void add(AttachedFile file);

  int addAll(List<AttachedFile> files);

  int delete(int no);

  int deleteAll(int boardNo);

  List<AttachedFile> findAllByBoardNo(int boardNo);

  AttachedFile findByNo(int no);

}
