package utils;

import java.util.Scanner;

public class Prompt {
  public static final String PROMPT = "> ";

  private static Scanner scanner = new Scanner(System.in);

  public static String getString(String message) {
    System.out.println("");
    System.out.println(message);
    System.out.print(PROMPT);
    return getLine();
  }

  public static int getInt(String message) {
    while (true) {
      try {
        return Integer.parseInt(getString(message));

      } catch (NumberFormatException e) {
        System.out.println("Error! Invalid integer value. Try again.");
      }
    }
  }

  public static float getFloat(String message) {
    while (true) {
      try {
        return Float.parseFloat(getString(message));

      } catch (NumberFormatException e) {
        System.out.println("Error! Invalid float value. Try again.");
      }
    }
  }

  public static double getDouble(String message) {
    while (true) {
      try {
        return Double.parseDouble(getString(message));

      } catch (NumberFormatException e) {
        System.out.println("Error! Invalid double value. Try again.");
      }
    }
  }

  public static boolean getBoolean(String message) {
    while (true) {
      String input = getString(message + " (y/n) ");

      if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
        return true;
      } else if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) {
        return false;
      } else {
        System.out.println("Error! Invalid response. Try again.");
      }
    }
  }

  private static String getLine() {
    scanner = new Scanner(System.in);
    return scanner.nextLine();
  }
}
