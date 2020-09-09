package mini.project.Handler;

public class MemberHandler {

  public void add() {
    System.out.println("[사용자 등록]");

    Member member = new Member();
    member.setName(Prompt.inputString("이름? "));
    member.setEmail(Prompt.inputString("목표타수"));
    
    

    memberList.add(member);
  }



}
