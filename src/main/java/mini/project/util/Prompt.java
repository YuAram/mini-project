package mini.project.util;

import java.util.Scanner;

public class Prompt {
  static Scanner keyboardScan = new Scanner(System.in);

  public static String inputString(String title) {
    System.out.print(title);
    return keyboardScan.nextLine();
  }

  public static int inputInt(String title) {
    int input = 0;
    try {
      input = Integer.parseInt(inputString(title));
    } catch(NumberFormatException  e) {
      input = -1;
      //System.err.println("##### inputInt() input Error \n");
    }
    return input;
  }

  public static void close() {
    keyboardScan.close();
  }

}