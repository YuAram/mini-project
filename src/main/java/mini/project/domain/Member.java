package mini.project.domain;

public class Member {
  private int no;
  private String name;
  private double averageTypingNumber;
  private double goalTypingNumber;
  private double accuracy;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public double getAverageTypingNumber() {
    return averageTypingNumber;
  }
  public void setAverageTypingNumber(double averageTypingNumber) {
    this.averageTypingNumber = averageTypingNumber;
  }
  public double getGoalTypingNumber() {
    return goalTypingNumber;
  }
  public void setGoalTypingNumber(double goalTypingNumber) {
    this.goalTypingNumber = goalTypingNumber;
  }
  public double getAccuracy() {
    return accuracy;
  }
  public void setAccuracy(double accuracy) {
    this.accuracy = accuracy;
  }
}
