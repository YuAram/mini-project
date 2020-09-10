package mini.project.domain;

public class Setting {
  private static int userNo;
  private static String userName;
  private static int testNumber;

  public static int getUserNo() {
    return userNo;
  }
  public static void setUserNo(int userNo) {
    Setting.userNo = userNo;
  }
  public static int getTestNumber() {
    return testNumber;
  }
  public static void setTestNumber(int testNumber) {
    Setting.testNumber = testNumber;
  }
  public static String getUserName() {
    return userName;
  }
  public static void setUserName(String userName) {
    Setting.userName = userName;
  }
}
