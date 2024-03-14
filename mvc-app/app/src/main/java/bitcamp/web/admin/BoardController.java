package bitcamp.web.admin;

import bitcamp.dao.BoardDao;
import bitcamp.vo.Board;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

  private static Log log = LogFactory.getLog(BoardController.class);

  @Autowired
  BoardDao boardDao; // 이 객체는 ContextLoaderListener에서 관리하는 객체이다.

  public BoardController(BoardDao boardDao) {
    log.debug("BoardController() 호출됨!");
  }

  @RequestMapping(path = "/board/list", produces = "text/plain;charset=UTF-8")
  @ResponseBody
  public String list() throws Exception {
    List<Board> boards = boardDao.findAll();

    StringBuffer sb = new StringBuffer();
    for (Board board : boards) {
      sb.append(board.toString() + "\n");
    }
    return sb.toString();
  }
}