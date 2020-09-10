package mini.project.util;

import java.util.Scanner;

public class Prompt {
  static Scanner keyboardScan = new Scanner(System.in);

  public static String inputString(String title) {
    System.out.print(title);

    String input;
    try {
      input = keyboardScan.nextLine();
    } catch(java.util.NoSuchElementException e) {
      //System.err.println("##### inputString() input Error \n");
      input = " ";
    }
    return input;
  }

  public static int inputInt(String title) {
    int input = 0;
    try {
      input = Integer.parseInt(inputString(title));
    } catch(NumberFormatException  e) {
      //System.err.println("##### inputInt() input Error \n");
      input = -1;
    }
    return input;
  }

  public static void close() {
    keyboardScan.close();
  }

}