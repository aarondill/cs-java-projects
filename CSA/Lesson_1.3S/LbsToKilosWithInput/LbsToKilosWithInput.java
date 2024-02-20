import java.util.Scanner;
import java.util.function.Supplier;

/**
 * public class LbsToKilosWithInput
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    08/23/23
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: The formula to convert a weight in pounds to kilograms is:
 * pounds/2.205. Write a program that will allow the user to enter a weight in
 * pounds then convert that weight to kilograms and print the result. Declare
 * double type variables or pounds and kilograms named lbs and kg. Prompt the
 * user for the weight in pounds and then assign the value entered to lbs. Then
 * use that variable to calculate the kilograms and assign the result to kg.
 * Output the weight in pounds and the weight in kilograms as shown in the
 * sample run shown below.
 * 
 */
public class LbsToKilosWithInput {
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
      double lbs = args.length > 0 ? Double.parseDouble(args[0])
          : prompt(scan::hasNextDouble, scan::nextDouble, "Enter the weight in pounds: ");
      double kg = lbs / 2.205;
      System.out.println(lbs + " pounds = " + kg + " kilograms");
    }
  }
}
