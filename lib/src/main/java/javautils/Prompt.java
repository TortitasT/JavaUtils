package javautils;

import java.util.Scanner;

public class Prompt {
  private static Scanner scanner = new Scanner(System.in);

  public static <T> T get(String prompt, Class<T> type) {
    if (type == String.class) {
      return (T) getString(prompt);
    } else if (type == Integer.class) {
      return (T) Integer.valueOf(getInt(prompt));
    } else if (type == Double.class) {
      return (T) Double.valueOf(getDouble(prompt));
    } else {
      throw new IllegalArgumentException("Invalid type: " + type.getName());
    }
  }

  public static String getString(String prompt) {
    System.out.print(prompt);
    String s = scanner.nextLine(); // read user entry
    return s;
  }

  public static int getInt(String prompt) {
    int i = 0;
    boolean isValid = false;
    while (!isValid) {
      System.out.print(prompt);
      if (scanner.hasNextInt()) {
        i = scanner.nextInt();
        isValid = true;
      } else {
        System.out.println("Error! Invalid integer value. Try again.");
      }
      scanner.nextLine(); // discard any other data entered on the line
    }
    return i;
  }

  public static int getInt(String prompt, int min, int max) {
    int i = 0;
    boolean isValid = false;
    while (!isValid) {
      i = getInt(prompt);
      if (i <= min)
        System.out.println("Error! Number must be greater than " + min + ".");
      else if (i >= max)
        System.out.println("Error! Number must be less than " + max + ".");
      else
        isValid = true;
    }
    return i;
  }

  public static double getDouble(String prompt) {
    double d = 0;
    boolean isValid = false;
    while (!isValid) {
      System.out.print(prompt);
      if (scanner.hasNextDouble()) {
        d = scanner.nextDouble();
        isValid = true;
      } else {
        System.out.println("Error! Invalid decimal value. Try again.");
      }
      scanner.nextLine(); // discard any other data entered on the line
    }
    return d;
  }
}
