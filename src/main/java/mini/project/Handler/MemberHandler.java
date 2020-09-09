package mini.project.Handler;

import java.util.List;
import mini.project.domain.Member;
import mini.project.util.Prompt;

public class MemberHandler {
  List<Member> memberList;

  public MemberHandler(List<Member> list) {
    this.memberList = list;
  }
  public void test() {
    System.out.println("MemberHandler");
  }

  public void add() {
    System.out.println("[사용자 등록]");

    Member member = new Member();
    member.setName(Prompt.inputString("이름? "));
    member.setGoalTypingNumber(Prompt.inputInt("목표타수"));
    
    memberList.add(member);
  }
  public void list() {
    System.out.println("사용자 목록 조회");
    
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      System.out.printf("%d, %s, %d, %d, %d\n",
          member.getNo(),
          member.getName(),
          member.getAverageTypingNumber(),
          member.getGoalTypingNumber(),
          member.getAccuracy());
     
      
    }
  }
  
  public void update() {
    System.out.println("[회원 변경]");
  
    String name = Prompt.inputString(
        String.format("이름(%s)? ", member.getName()));
    String email = Prompt.inputString(
        String.format("목표타수(%s)? ", member.getEmail()));


    String response = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
      
    }
  }
  
  
  
  
  
}