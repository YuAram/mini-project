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

  public void show() {
    System.out.println("[설정 조회]");
    if(Setting.getUserNo() == -1) {
      System.out.printf("현재 사용자 번호 : None.\n");
    } else {
      System.out.printf("현재 사용자 번호 : %d\n", Setting.getUserNo());
    }
    System.out.printf("현재 테스트 횟수 : %d\n", Setting.getTestNumber());
  }

  public void userNo() {
    System.out.println("[사용자 설정]");
    int userNo = Prompt.inputInt("변경할 사용자 번호(" + Setting.getUserNo() + ")? ");
    int index = indexOf(userNo);

    if (index == -1) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    Setting.setUserNo(userNo);
  }

  public void testNumber() {
    System.out.println("[테스트 횟수 설정]");
    int testNumber = Prompt.inputInt("변경할 테스트 횟수(" + Setting.getTestNumber() + ")? ");

    if ((testNumber < 0) || (testNumber > 100)) {
      System.out.println("설정한 테스트 횟수가 너무 많거나 적습니다.");
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
