package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Board;
import java.util.List;

public class BoardDao extends AbstractDao<Board>{
  public void add(Board board){
    this.list.add(board);
  }

  public int delete(int no){
    if(no < 0 || no >= this.list.size()){
      return 0;
    }
    this.list.remove(no);
    return 1;
  }
  public List<Board> findAll() {
    return this.list.subList(0, list.size());
  }

  public Board findBy(int no){
    if(no < 0 || no >= list.size()){
      return null; //유효할 때
    }
    return list.get(no);
  }

  public int update(int no, Board board){
    if(no<0 || no >= list.size()){
      return 0;
    }
    list.set(no,board);
    saveData();
    return 1;
  }

  public BoardDao(String filepath) {
    super(filepath);
  }
}
