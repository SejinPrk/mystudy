package app.myapp.dao.mysql;

import app.myapp.dao.CategoryDao;
import app.myapp.dao.DaoException;
import app.myapp.vo.Category;
import app.util.DBConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CategoryDaoImpl implements CategoryDao {
  DBConnectionPool connectionPool;

  public CategoryDaoImpl(DBConnectionPool connectionPool) { this.connectionPool = connectionPool;}

  @Override
  public void add(Category category) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "insert into category(name) values(?)")) {
      pstmt.setString(1, category.getName());
      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "delete from category where category_no=?")) {
      pstmt.setInt(1, no);
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Category> findAll() {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "select category_no, name from category");
        ResultSet rs = pstmt.executeQuery()) {

      ArrayList<Category> list = new ArrayList<>();

      while (rs.next()) {
        Category category = new Category();
        category.setNo(rs.getInt("category_no"));
        category.setName(rs.getString("name"));

        list.add(category);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Category findBy(int no) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "select category_no, name from category where category_no=?")){
      pstmt.setInt(1, no);

      try(ResultSet rs = pstmt.executeQuery()) {

        if (rs.next()) {
          Category category = new Category();
          category.setNo(rs.getInt("category_no"));
          category.setName(rs.getString("name"));
          return category;
        }
        return null;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Category category) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "update category set name=? where category_no=?")){
      pstmt.setString(1, category.getName());
      pstmt.setInt(2, category.getNo());

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }
}
