import java.util.Scanner;

/**
 * public class AverageRounded
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    08/29/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: allow the user to enter three positive decimal values, find
 * the average of those three values, round it to a whole number and print the
 * result. For this lab you may only declare and use one variable to read in the
 * values and you must use compound assignment to add up the values. There are
 * two possible ways to have the user input the data for this program. Both are
 * shown below along with the output.
 * 
 * <pre>
 * Enter three positive decimal numbers:
 * 2.36
 * 1.84
 * 4.15
 * Average = 3
 * </pre>
 */
public class AverageRounded {
  private static final int COUNT = 3;

  private static void abort(String message) {
    System.err.println(message);
    System.exit(1);
  }

  private static double nextDouble(Scanner scan) {
    if (!scan.hasNextDouble())
      abort("Please enter a valid number");
    double val = scan.nextDouble();
    if (val < 0)
      abort("Please enter a positive number");
    return val;
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.println("Enter three positive decimal numbers:");
      double total = 0;
      for (int i = 0; i < COUNT; i++)
        total += nextDouble(scan);
      System.out.println("Average = " + (int) ((total / COUNT) + 0.5));
    }
  }
}
