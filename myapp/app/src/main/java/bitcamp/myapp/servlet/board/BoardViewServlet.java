package bitcamp.myapp.servlet.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardViewServlet extends HttpServlet {

  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;

  public BoardViewServlet(BoardDao boardDao, AttachedFileDao attachedFileDao) {
    this.boardDao = boardDao;
    this.attachedFileDao = attachedFileDao;
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>비트캠프 데브옵스 5기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글</h1>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Board board = boardDao.findBy(no);
      if (board == null) {
        out.println("<p>게시글 번호가 유효하지 않습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      List<AttachedFile> files = attachedFileDao.findAllByBoardNo(no);
      out.println("<form action='/board/add'>");
      out.println("<div>");
      out.printf("  제목: <input name='title' type='text' value='%s'>\n", board.getTitle());
      out.println("</div>");
      out.println("<div>");
      out.printf("  내용: <textarea name='content'></textarea>\n", board.getContent());
      out.println("</div>");
      out.println("<div>");
      out.println("  첨부파일: <input multiple name='files' type='file'>");
      out.println(" <ul>");
      for (AttachedFile file : files) {
        out.printf("   <li>%s</li>\n", file.getFilePath());
      }
      out.println(" </ul>");
      out.println("</div>");
      out.println("<div>");
      out.println(" <button>변경</button>");
      out.println("</div>");
      out.println("</form>v");

    } catch (Exception e) {
      out.println("<p>조회 오류!</p>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
/*
[조회]
번호? 7
번호: 7
제목: a2
내용: aa2
작성자: a
작성일: 2024-02-14 00:00:00
첨부파일:
  a1.gif
  a2.gif
  a3.gif
 */