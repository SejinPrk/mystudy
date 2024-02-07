package app.myapp.dao.mysql;

import app.myapp.dao.BoardDao;
import app.myapp.dao.DaoException;
import app.myapp.vo.Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl implements BoardDao {

  int category;
  Connection con;

  public BoardDaoImpl(Connection con, int category) {
    this.con = con;
    this.category = category;
  }

  @Override
  public void add(Report board) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "insert into boards(title,content,writer,category) values(?,?,?,?)")) {

      pstmt.setString(1, board.getTitle());
      pstmt.setString(2, board.getContent());
      pstmt.setString(3, board.getWriter());
      pstmt.setInt(4, category);

      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "delete from boards where board_no=?")) {

      pstmt.setInt(1, no);

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Report> findAll() {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select board_no, title, writer, created_date"
            + " from boards where category=? order by board_no desc")) {

      pstmt.setInt(1, category);

      try (ResultSet rs = pstmt.executeQuery()) {

        ArrayList<Report> list = new ArrayList<>();

        while (rs.next()) {
          Report board = new Report();
          board.setNo(rs.getInt("board_no"));
          board.setTitle(rs.getString("title"));
          board.setWriter(rs.getString("writer"));
          board.setCreatedDate(rs.getDate("created_date"));

          list.add(board);
        }
        return list;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Report findBy(int no) {
    try (PreparedStatement pstmt = con.prepareStatement("select * from boards where board_no=?")) {

      pstmt.setInt(1, no);

      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          Report board = new Report();
          board.setNo(rs.getInt("board_no"));
          board.setTitle(rs.getString("title"));
          board.setContent(rs.getString("content"));
          board.setWriter(rs.getString("writer"));
          board.setCreatedDate(rs.getDate("created_date"));

          return board;
        }
        return null;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Report board) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "update boards set title=?, content=?, writer=? where board_no=?")) {

      pstmt.setString(1, board.getTitle());
      pstmt.setString(2, board.getContent());
      pstmt.setString(3, board.getWriter());
      pstmt.setInt(4, board.getNo());

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }
}
