import java.util.Scanner;

/**
 * public class TempConversionImproved
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    08/21/2023
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
public class TempConversionImproved {
  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("Enter a temperature in Fahrenheit: ");
      if (!scan.hasNextDouble()) {
        System.out.println("You must input a number!");
        System.exit(2);
        return;
      }
      double fahrenheight = scan.nextDouble();
      double celsius = (fahrenheight - 32) * 5 / 9;
      System.out.format("Fahrenheit = %.2f\nCelsius = %.2f\n", fahrenheight,
          celsius);
    }
  }
}
