import java.util.Scanner;

/**
 * public class RoundNegatives
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    08/29/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: allow the user to enter a negative decimal number and then
 * prints that number rounded to the nearest whole number. Test your program
 * using -3.21 and -9.86. Here is a sample run for both test values.
 *
 * <pre>
 * Enter a negative decimal number: -3.21
 * -3.21 rounded to a whole number is -3
 * </pre>
 * 
 * <pre>
 * Enter a negative decimal number: -9.86
 * -9.86 rounded to a whole number is -10
 * </pre>
 */
public class RoundNegatives {
  private static void abort(String msg) {
    abort(msg, 1);
  }

  private static void abort(String msg, int code) {
    System.err.println(msg);
    System.exit(code);
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("Enter a negative decimal number: ");
      if (System.console() == null)
        System.out.println();
      if (!scan.hasNextDouble())
        abort("Please enter a valid number.");
      double val = scan.nextDouble();
      if (val >= 0)
        abort("You must enter a negative number.");
      int res = (int) (val * -1 + 0.5) * -1;
      System.out.println(val + " rounded to a whole number is " + res);
    }
  }
}
