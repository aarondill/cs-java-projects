import java.util.Scanner;

/**
 * Primary java class: NegativeExponent
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/06/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Lab 4.2.7 – NegativeExponent - Modify lab 4.2.6 so that the
 * user may enter a positive or negative base and a positive or negative
 * exponent. Powers are no longer limited to Integer.MAX_VALUE. Again, DO NOT
 * use Math.pow(x,y). (Hint: Variables can no longer all be int type.) There is
 * no starter file for this lab. You must write the entire class. (see Topic 4.2
 * Practice Labs
 *
 */
public class NegativeExponent {
  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("Enter the base: ");
      double base = scan.nextDouble();
      System.out.print("Enter the exponent: ");
      double exponent = scan.nextDouble();
      double value = exponent == 0 ? 1 : base;
      double absExp = exponent < 0 ? -exponent : exponent;
      for (double i = 1; i < absExp; i++)
        value *= base;
      if (exponent < 0) value = 1 / value;
      System.out.printf("%.0f ^ %.0f = %s\n", base, exponent, value);
    }
  }
}
