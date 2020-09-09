package mini.project.Handler;

import mini.project.util.Prompt;

public class TypingHandler {

  static final int TEST_COUNT = 5;

  public void test() {
    System.out.println("TypingHandler");
  }

  public void phoneticSymbol() {
    System.out.println("[자리 연습]");
    char question;
    char answer;
    int score=0;

    for (int i = 1; i <= TEST_COUNT; i++) {
      question = (char)((Math.random() * 26) + 97); // 97 ~ 122
      System.out.printf("Quiz%02d : %c\n", i ,question);
      answer = Prompt.inputChar("~> ");

      if (question == answer) {
        score++;
      }

      System.out.printf("맞춘 개수 : %d\n",score);
      System.out.printf("정확도 : %.2f\n",((double)score / i) * 100);
      System.out.println("- - - - - - - - - - - - - - -");
    }
    System.out.printf("Total : 맞춘 개수(%d / %d), 정확도(%.2f)\n", 
        score, TEST_COUNT, ((double)score / TEST_COUNT) * 100);
  }

  public void word() {
    System.out.println("[낱말 연습]");
    String[] words = {"potato", "onion", "corn", "pizza", "chicken", 
        "hamburger", "noodles", "noodles", "noodles", "bulgogi"};
    String question;
    String answer;
    int score=0;

    for (int i = 1; i <= TEST_COUNT; i++) {
      question = words[(int)((Math.random() * words.length) + 0)]; // 0 ~ 9
      System.out.printf("Quiz%02d : %s\n", i ,question);
      answer = Prompt.inputString("~> ");

      if (question.equals(answer)) {
        score++;
      }

      System.out.printf("맞춘 개수 : %d\n",score);
      System.out.printf("정확도 : %.2f\n",((double)score / i) * 100);
      System.out.println("- - - - - - - - - - - - - - -");
    }
    System.out.printf("Total : 맞춘 개수(%d / %d), 정확도(%.2f)\n", 
        score, TEST_COUNT, ((double)score / TEST_COUNT) * 100);
  }
}