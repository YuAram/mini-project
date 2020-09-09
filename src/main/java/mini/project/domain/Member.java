package mini.project.domain;

public class Member {
  private int no;
  private String name;
  private double accuracy;
  private int testCount;

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
  public double getAccuracy() {
    return accuracy;
  }
  public void setAccuracy(double accuracy) {
    this.accuracy = accuracy;
  }
  public int getTestCount() {
    return testCount;
  }
  public void setTestCount(int testCount) {
    this.testCount = testCount;
  }
}
