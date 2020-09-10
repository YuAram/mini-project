package mini.project.Handler;

import java.util.List;
import mini.project.domain.Member;
import mini.project.domain.Setting;
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
    System.out.println("[짧은 글 연습]");

    typingPractice(sentences);
  }

  private void typingPractice(String[] contents) {
    String question;
    String answer;
    int score = 0;
    double startTime, endTime, currentTime;
    double time = 0;
    double accuracy;
    int index = indexOf(Setting.getUserNo());
    Member member;

    if (index == -1) {
      System.out.println("### 사용자 등록 먼저 해주세요~");
      return;
    }

    for (int i = 1; i <= Setting.getTestNumber(); i++) {
      question = contents[randMake(0, contents.length)];

      System.out.printf("%02d.[%s]\n", i ,question);
      startTime = System.currentTimeMillis();

      answer = Prompt.inputString(" ~> ");
      endTime = System.currentTimeMillis();

      if (question.equals(answer)) {
        score++;
        currentTime = timeCompute(startTime, endTime);
        time += currentTime;
      } else {
        currentTime = 0.0;
      }
      scorePrint(score, accuracyCompute(score, i), currentTime);
    }
    accuracy = accuracyCompute(score, Setting.getTestNumber());
    totalScorePrint(score, accuracy, timeAverageCompute(time, score));

    member = memberList.get(index);
    member.setTestCount(member.getTestCount() + 1);
    member.setAccuracy(userAccuracyCompute(member.getAccuracy(), accuracy, member.getTestCount()));
  }

  private int randMake(int firstNumber, int length) {
    return (int)((Math.random() * length) + firstNumber);
  }

  private double userAccuracyCompute(double oldAccuracy, double newAccuracy, int testCount) {
    return (oldAccuracy * (testCount - 1) + newAccuracy) / testCount;
  }

  private double accuracyCompute(int score, int count) {
    return ((double)score / count) * 100;
  }

  private double timeCompute(double start, double end) {
    return (end - start) / 1000.0; 
  }

  private double timeAverageCompute(double time, int count) {
    if (count == 0) return 0.0;
    return time / count; 
  }

  private void scorePrint(int score, double accuracy, double countTime) {
    System.out.printf(">> 맞춘 개수 : %d개 / 정확도 : %.2f / 걸린시간 : %.2f초\n"
        ,score ,accuracy ,countTime);
    System.out.println("- - - - - - - - - - - - - - - - - - - -");
  }

  private void totalScorePrint(int score, double accuracy, double averageCountTime) {
    System.out.println("- - - - - - - - - - - - - - - - - - - -");
    System.out.printf("* Total\n"
        + ">> 맞춘 개수 : %d개 / %d개\n"
        + ">> 정확도 : %.2f\n"
        + ">> 평균시간 : %.2f초\n",
        score, Setting.getTestNumber(), accuracy, averageCountTime);
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