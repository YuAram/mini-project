package mini.project.Handler;

import java.util.List;
import mini.project.domain.Member;
import mini.project.util.Prompt;

public class TypingHandler {

  List<Member> memberList;

  String[] phoneticSymbols = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
      "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
      "u", "v", "w", "x", "y", "z"};

  String[] words = {"potato", "onion", "corn", "pizza", "chicken", 
      "hamburger", "noodles", "candy", "chocolate", "bulgogi"};

  String[] sentences = {"Think like a man of action and act like man of thought.",
      "Courage is very important. Like a muscle, it is strengthened by use.",
      "Life is the art of drawing sufficient conclusions from insufficient premises.",
      "By doubting we come at the truth.",
      "A man that hath no virtue in himself, ever envieth virtue in others.",
      "When money speaks, the truth keeps silent.",
  "COVID-19 OUT!"};

  public TypingHandler(List<Member> memberList) {
    this.memberList = memberList;
  }

  public void phoneticSymbol() {
    System.out.println("[자리 연습]");

    typingPractice(phoneticSymbols);
  }

  public void word() {
    System.out.println("[낱말 연습]");

    typingPractice(words);
  }

  public void sentence() {
    System.out.println("[낱말 연습]");

    typingPractice(sentences);
  }

  private void typingPractice(String[] contents) {
    String question;
    String answer;
    int score = 0;
    double startTime, endTime;

    for (int i = 1; i <= TEST_COUNT; i++) {
      question = contents[randMake(0, contents.length)]; // 0 ~ 9

      System.out.printf("Quiz%02d : %s\n", i ,question);
      startTime = System.currentTimeMillis();

      answer = Prompt.inputString("~> ");
      endTime = System.currentTimeMillis();

      if (question.equals(answer)) {
        score++;
      }
      scorePrint(score, accuracyCompute(score, i), timeCompute(startTime, endTime));
    }
    totalScorePrint(score, accuracyCompute(score, TEST_COUNT));
  }

  private int randMake(int firstNumber, int length) {
    return (int)((Math.random() * length) + firstNumber);
  }

  private double accuracyCompute(int score, int count) {
    return ((double)score / count) * 100;
  }

  private double timeCompute(double start, double end) {
    return (start - end)/1000.0; 
  }

  private void scorePrint(int score, double accuracy, double d) {
    System.out.printf("맞춘 개수 : %d개\n", score);
    System.out.printf("정확도 : %.2f\n", accuracy);
    System.out.printf("걸린시간 : %.2f초\n", d);
    System.out.println("- - - - - - - - - - - - - - - - - - - -");
  }

  private void totalScorePrint(int score, double accuracy) {
    System.out.printf("Total >> 맞춘 개수(%d개 / %d개), 정확도(%.2f)\n", 
        score, TEST_COUNT, accuracy);
  }
}