package mini.project.Handler;

import java.util.LinkedList;
import java.util.List;
import mini.project.domain.Member;
import mini.project.util.Prompt;

public class MemberHandler {
  List<Member> memberList = new LinkedList<>();

  public void test() {
    System.out.println("MemberHandler");
  }

  public void add() {
    System.out.println("[사용자 등록]");

    Member member = new Member();
    member.setNo(Prompt.inputInt("번호? "));
    member.setName(Prompt.inputString("이름? "));
    member.setGoalTypingNumber(Prompt.inputInt("목표타수? "));

    memberList.add(member);
  }

  public void list() {
    System.out.println("사용자 목록 조회");

    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      System.out.printf("%d, %s, %f, %f, %f\n",
          member.getNo(),
          member.getName(),
          member.getAverageTypingNumber(),
          member.getGoalTypingNumber(),
          member.getAccuracy());
    }
  }

  public void update() {
    System.out.println("[회원 변경]");
    Member member = findByNo(Prompt.inputInt("번호? "));

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String name = Prompt.inputString(
        String.format("이름(%s)? ", member.getName()));
    int goalTypingNumber = Prompt.inputInt(
        String.format("목표타수(%s)? ", member.getGoalTypingNumber()));

    String response = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }

    member.setName(name);
    member.setGoalTypingNumber(goalTypingNumber);
  }

  public void delete() {
    System.out.println("[회원 삭제]");
    int no = Prompt.inputInt("번호? ");
    int index = indexOf(no);

    if (index == -1) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String response = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("회원 삭제를 취소하였습니다.");
      return;
    }

    memberList.remove(index);
    System.out.println("회원을 삭제하였습니다.");
  }

  private Member findByNo(int no) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (member.getNo() == no) {
        return member;
      }
    }
    return null;
  }

  private int indexOf(int no) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (member.getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}