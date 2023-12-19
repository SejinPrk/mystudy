package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;
import java.util.ArrayList;


public class AssignmentModifyHandler extends AbstractMenuHandler {

  private ArrayList<Assignment> objectRepository;

  public AssignmentModifyHandler(ArrayList<Assignment> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;

  }

  @Override
  protected void action() {
    int index = this.prompt.inputInt("번호? ");
    Assignment oldAssignment = this.objectRepository.get(index);
    if (oldAssignment == null) {
      System.out.println("과제 번호가 유효하지 않습니다.");
      return;
    }

    Assignment assignment = new Assignment();
    assignment.setTitle(this.prompt.input("과제명(%s)? ", oldAssignment.getTitle()));
    assignment.setContent(this.prompt.input("내용(%s)? ", oldAssignment.getContent()));
    assignment.setDeadline(this.prompt.input("제출 마감일(%s)? ", oldAssignment.getDeadline()));

    this.objectRepository.set(index, assignment);
  }
}