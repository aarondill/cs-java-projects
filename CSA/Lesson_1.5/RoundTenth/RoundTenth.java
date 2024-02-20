import java.util.Scanner;

/**
 * public class RoundTenth
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    08/29/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: will allow the user to enter a positive decimal number.
 * Round that value to the nearest tenth and print the result. Here is a sample
 * run and its output.
 * 
 * <pre>
 * Decimal number? 11.487
 * 11.487 rounded to the nearest tenth is 11.5
 * </pre>
 */
public class RoundTenth {
  private static void abort(String message) {
    System.err.println(message);
    System.exit(1);
  }

  private static double nextDouble(Scanner scan) {
    System.out.print("Decimal number? ");
    if (System.console() == null) {
      System.out.println();
    }
    if (!scan.hasNextDouble()) {
      abort("Please enter a valid decimal number.");
    }
    double val = scan.nextDouble();
    if (val < 0) {
      abort("Please enter a positive decimal number.");
    }
    return val;
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      double val = nextDouble(scan);
      System.out.println(val + " rounded to the nearest tenth is " + (int) ((val * 10.0) + 0.5) / 10.0);
    }
  }
}
