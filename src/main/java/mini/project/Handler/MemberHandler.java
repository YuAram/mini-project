package mini.project.Handler;

import mini.project.domain.Member;
import mini.project.util.Prompt;

public class MemberHandler {

  public void test() {
    System.out.println("MemberHandler");
  }

  public void add() {
    System.out.println("[사용자 등록]");

    Member member = new Member();
    member.setName(Prompt.inputString("이름? "));
    member.setGoalTypingNumber(Prompt.inputString("목표타수"));
  }
}