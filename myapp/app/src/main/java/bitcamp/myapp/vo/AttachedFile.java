package bitcamp.myapp.vo;

public class AttachedFile {

  private int no;
  private String filePath;
  private int boardNo;
  private int assignmentNo;
  private int memberNo;

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public int getBoardNo() {
    return boardNo;
  }

  public void setBoardNo(int boardNo) {
    this.boardNo = boardNo;
  }

  public AttachedFile filePath(String filePath) {
    this.filePath = filePath;
    return this;
  }
  public int getAssignmentNo() {
    return assignmentNo;
  }

  public void setAssignmentNo(int assignmentNo) {
    this.assignmentNo = assignmentNo;
  }

  public int getMemberNo() {
    return memberNo;
  }

  public void setMemberNo(int memberNo) {
    this.memberNo = memberNo;
  }

}
