package utils;

import java.util.Scanner;

/**
 * A utility class for prompting the user for input.
 * 
 * @author Victor Garcia Fernandez
 *
 */
public class Prompt {
  // The prompt to display to the user when asking for input.
  public static final String PROMPT = "> ";

  private static Scanner scanner = new Scanner(System.in);

  /**
   * Gets a value from the user. The message is printed, and the user's input is
   * returned. The type parameter determines the type of the value returned.
   * 
   * @param message
   * @param type
   * @return T
   */
  public static <T> T get(String message, Class<T> type) {
    if (type == String.class) {
      return type.cast(getString(message));

    } else if (type == Integer.class) {
      return type.cast(getInt(message));

    } else if (type == Float.class) {
      return type.cast(getFloat(message));

    } else if (type == Double.class) {
      return type.cast(getDouble(message));

    } else if (type == Boolean.class) {
      return type.cast(getBoolean(message));

    } else {
      throw new IllegalArgumentException("Invalid type: " + type);
    }
  }

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
