package mini.project.Handler;

import java.util.List;
import mini.project.domain.Member;
import mini.project.domain.Setting;
import mini.project.util.Prompt;

public class SettingHandler {

  static final int DEFAULT_COUNT = 10;

  List<Member> memberList;

  public SettingHandler(List<Member> memberList) {
    Setting.setTestNumber(DEFAULT_COUNT);
    Setting.setUserNo(-1);

    this.memberList = memberList;
  }

  public void list() {
    System.out.println("[설정 조회]");

    System.out.printf("현재 테스트 횟수 : %d\n", Setting.getTestNumber());

    if(Setting.getUserNo() == -1) {
      System.out.println("현재 등록된 사용자가 없습니다. 사용자를 등록 해주세요.");
    } else {
      System.out.printf("현재 사용자 번호 : %d(%s)\n", Setting.getUserNo(), Setting.getUserName());
    }
  }

  public void userNo() {
    System.out.println("[현재 사용자 설정]");

    int userNo = Prompt.inputInt("변경할 사용자 번호(" + Setting.getUserNo() + ")? ");
    int index = indexOf(userNo);

    if (index == -1) {
      System.out.println("### 해당 번호의 회원이 없습니다.");
      return;
    }

    Setting.setUserNo(userNo);
    Setting.setUserName(memberList.get(index).getName());
  }

  public void testNumber() {
    System.out.println("[테스트 횟수 설정]");
    int testNumber = Prompt.inputInt("변경할 테스트 횟수(" + Setting.getTestNumber() + ")? ");

    if ((testNumber < 1) || (testNumber > 100)) {
      System.out.println("### 설정한 테스트 횟수가 너무 많거나 적습니다.");
      return;
    }

    Setting.setTestNumber(testNumber);
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
