package mini.project.Handler;

import mini.project.util.Prompt;

public class TypingHandler {

  static final int TEST_COUNT = 5;

  String[] phoneticSymbols = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
      "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
      "u", "v", "w", "x", "y", "z"};

  String[] words = {"potato", "onion", "corn", "pizza", "chicken", 
      "hamburger", "noodles", "noodles", "noodles", "bulgogi"};

  public void phoneticSymbol() {
    System.out.println("[자리 연습]");

    typingPractice(phoneticSymbols);
  }

  public void word() {
    System.out.println("[낱말 연습]");

    typingPractice(words);
  }

  private void typingPractice(String[] contents) {
    String question;
    String answer;
    int score = 0;
    double start, end;

    for (int i = 1; i <= TEST_COUNT; i++) {
      question = contents[(int)((Math.random() * contents.length) + 0)]; // 0 ~ 9
      System.out.printf("Quiz%02d : %s\n", i ,question);
      start = System.currentTimeMillis();

      answer = Prompt.inputString("~> ");
      end = System.currentTimeMillis();

      if (question.equals(answer)) {
        score++;
      }
      scorePrint(score, i, (end - start)/1000.0);
    }
    totalScorePrint(score);
  }

  private void scorePrint(int score, int count, double d) {
    System.out.printf("맞춘 개수 : %d개\n",score);
    System.out.printf("정확도 : %.2f\n", ((double)score / count) * 100);
    System.out.printf("걸린시간 : %.2f초\n", d);
    System.out.println("- - - - - - - - - - - - - - - - - - - -");
  }

  private void totalScorePrint(int score) {
    System.out.printf("Total >> 맞춘 개수(%d개 / %d개), 정확도(%.2f)\n", 
        score, TEST_COUNT, ((double)score / TEST_COUNT) * 100);
  }
}