import java.util.Scanner;
import java.util.function.Supplier;

/**
 * public class TempConUserInput
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    08/23/23
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program that will convert the current temperature
 * where you are from Fahrenheit to Celsius. Determine the current Fahrenheit
 * temperature and find the formula for the conversion before you begin. Declare
 * appropriately named variables that are of the correct type for each value you
 * use in the program and for values that are calculated using expressions. The
 * output should be appropriately labelled as you have done in each of the
 * previous four labs in this topic.
 *
 * 
 */
public class TempConUserInput {
  private static <T> T prompt(Supplier<Boolean> check, Supplier<T> func, String prompt) {
    System.out.print(prompt);
    if (check.get()) {
      return func.get();
    }
    System.out.println(); // after prompt
    throw new RuntimeException(
        "Something went wrong reading your input. Please ensure your input is the correct type."); // Should never be reached
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      double fahrenheight = args.length > 0 ? Double.parseDouble(args[0])
          : prompt(scan::hasNextDouble, scan::nextDouble, "Enter the current Fahrenheit temperature: ");
      double celsius = (fahrenheight - 32) * 5 / 9;
      System.out.format("%.1f degrees Fahrenheit = %.1f degrees Celsius\n", fahrenheight, celsius);
    }
  }
}
