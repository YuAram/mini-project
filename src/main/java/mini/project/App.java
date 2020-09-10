package mini.project;

import java.util.LinkedList;
import java.util.List;
import mini.project.Handler.MemberHandler;
import mini.project.Handler.SettingHandler;
import mini.project.Handler.TypingHandler;
import mini.project.domain.Member;
import mini.project.domain.Setting;
import mini.project.util.Prompt;

public class App {

  public static void main(String[] args) {

    List<Member> memberList = new LinkedList<>();
    MemberHandler memberHandler = new MemberHandler(memberList);

    SettingHandler settingHandler = new SettingHandler(memberList);
    TypingHandler typingHandler = new TypingHandler(memberList);

    String promptUserName;

    loop:
      while (true) {
        if(memberList.isEmpty()) promptUserName = "None";
        else promptUserName = Setting.getUserName();

        String command = Prompt.inputString("명령(" + promptUserName + ")> ");

        switch (command) {
          case "/typing/phoneticSymbol": typingHandler.phoneticSymbol(); break;
          case "/typing/word": typingHandler.word(); break;
          case "/typing/sentence": typingHandler.sentence(); break;

          case "/member/my": memberHandler.my(); break;
          case "/member/add": memberHandler.add(); break;
          case "/member/list": memberHandler.list(); break;
          case "/member/update": memberHandler.update(); break;
          case "/member/delete": memberHandler.delete(); break;

          case "/setting/list": settingHandler.list(); break;
          case "/setting/userNo": settingHandler.userNo(); break;
          case "/setting/testNumber": settingHandler.testNumber(); break;

          case "quit":
          case "exit":
            System.out.println(" * 프로그램이 종료되었습니다. * ");
            break loop;
          default:
            System.out.println("### 실행할 수 없는 명령입니다.");
        }
        System.out.println();
      }
    Prompt.close();
  }
}