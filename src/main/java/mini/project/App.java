package mini.project;

import mini.project.Handler.MemberHandler;
import mini.project.Handler.SettingHandler;
import mini.project.Handler.TypingHandler;
import mini.project.util.Prompt;

public class App {

  public static void main(String[] args) {

    TypingHandler typingHandler = new TypingHandler();
    MemberHandler memberHandler = new MemberHandler();
    SettingHandler settingHandler = new SettingHandler();

    loop:
      while (true) {
        String command = Prompt.inputString("명령> ");

        switch (command) {
          case "/typing/test": typingHandler.test(); break;
          case "/typing/phoneticSymbol": typingHandler.phoneticSymbol(); break;
          case "/typing/word": typingHandler.word(); break;
          // 제 부분

          case "/member/test": memberHandler.test(); break;
          // 소미씨 부분

          case "/setting/test": settingHandler.test(); break;
          // 이후 추가

          case "quit":
          case "exit":
            System.out.println(" * The End * ");
            break loop;
          default:
            System.out.println("실행할 수 없는 명령입니다.");
        }
        System.out.println();
      }
    Prompt.close();
  }
}

