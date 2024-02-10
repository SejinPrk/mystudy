package app.myapp.dao.mysql;

import app.myapp.dao.PlatformDao;
import app.myapp.dao.DaoException;
import app.myapp.vo.Platform;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlatformDaoImpl implements PlatformDao {

  Connection con;

  public PlatformDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Platform platform) {
    try (PreparedStatement pstmt = con.prepareStatement(
          "insert into platforms(name,price,term) values(?,?,?)")) {
        pstmt.setString(1, platform.getName());
        pstmt.setInt(2, platform.getPrice());
        pstmt.setString(3, platform.getTerm());

        pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "delete from platforms where platform_no=?")) {
      pstmt.setInt(1, no);
        return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Platform> findAll() {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select platform_no, name, price, term  from assignments order by platform_no desc");
        ResultSet rs = pstmt.executeQuery()) {

      ArrayList<Platform> list = new ArrayList<>();

      while (rs.next()) {
        Platform platform = new Platform();
        platform.setNo(rs.getInt("platform"));
        platform.setName(rs.getString("name"));
        platform.setPrice(rs.getInt("price"));
        platform.setTerm(rs.getString("term"));

        list.add(platform);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Platform findBy(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select * from platforms where platform_no=?")){

      pstmt.setInt(1, no);

      try(ResultSet rs = pstmt.executeQuery()) {

        if (rs.next()) {
          Platform platform = new Platform();
          platform.setNo(rs.getInt("platform_no"));
          platform.setName(rs.getString("name"));
          platform.setPrice(rs.getInt("price"));
          platform.setTerm(rs.getString("term"));
          return platform;
        }
        return null;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Platform platform) {
    try (PreparedStatement pstmt = con.prepareStatement(
          "update platforms set name=?, price=?, term=? where platform_no=?")) {
      pstmt.setString(1, platform.getName());
      pstmt.setInt(2, platform.getPrice());
      pstmt.setInt(3, platform.getNo());
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }
}
