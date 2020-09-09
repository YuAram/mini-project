package mini.project.Handler;

public class SettingHandler {

  public void update() {
    System.out.println("[게시물 변경]");
    int no = Prompt.inputInt("이름 ");
    Board board = findByNo(no);


    }

    String title = Prompt.inputString(
        String.format("이름(%s) ", board.getTitle()));
    String content = Prompt.inputString(
        String.format("목표타수(%s)? ", board.getContent()));
 

    String response = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    board.setTitle(title);
    board.setContent(content);
    board.setWriter(writer);
    System.out.println("게시글을 변경하였습니다.");
  }

}
