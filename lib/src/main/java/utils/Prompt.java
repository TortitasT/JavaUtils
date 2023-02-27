package utils;

import java.util.Scanner;

public class Prompt {
  // The prompt to display to the user when asking for input.
  public static final String PROMPT = "> ";

  private static Scanner scanner = new Scanner(System.in);

  /**
   * Gets a string from the user. The message is printed, and the user's input is
   * returned.
   * 
   * @param message
   * @return String
   */
  public static String getString(String message) {
    System.out.println("");
    System.out.println(message);
    System.out.print(PROMPT);
    return getLine();
  }

  /**
   * Gets an integer from the user. The message is printed, and the user's input
   * is returned.
   * 
   * @param message
   * @return int
   */
  public static int getInt(String message) {
    while (true) {
      try {
        return Integer.parseInt(getString(message));

      } catch (NumberFormatException e) {
        System.out.println("Error! Invalid integer value. Try again.");
      }
    }
  }

  /**
   * Gets a float from the user. The message is printed, and the user's input is
   * returned.
   * 
   * @param message
   * @return float
   */
  public static float getFloat(String message) {
    while (true) {
      try {
        return Float.parseFloat(getString(message));

      } catch (NumberFormatException e) {
        System.out.println("Error! Invalid float value. Try again.");
      }
    }
  }

  /**
   * Gets a double from the user. The message is printed, and the user's input is
   * returned.
   * 
   * @param message
   * @return double
   */
  public static double getDouble(String message) {
    while (true) {
      try {
        return Double.parseDouble(getString(message));

      } catch (NumberFormatException e) {
        System.out.println("Error! Invalid double value. Try again.");
      }
    }
  }

  /**
   * Gets a boolean from the user. The message is printed, and the user's input is
   * returned. The user must enter "y" or "n" and case is ignored.
   * 
   * @param message
   * @return boolean
   */
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
