import java.util.Scanner;

/**
 * Primary java class: FindThePower
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    09/25/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Lab 2.9.2 - FindThePower – Write a program that will prompt the user for the
 * base and the exponent of a power. Calculate and print the value of that
 * power. You must use a variable to store the value of the power and then use
 * that variable in the output statement. Format the output as shown in the
 * sample run.
 * 
 * <pre>
 * Enter the base: 2
 * Enter the exponent: 3
 * 2^3 = 8.0
 * </pre>
 *
 */
public class FindThePower {
  public static void main(String... args) {
    try (Scanner input = new Scanner(System.in)) {
      System.out.print("Enter the base: ");
      int base = input.nextInt();
      System.out.print("Enter the exponent: ");
      int exponent = input.nextInt();
      double power = Math.pow(base, exponent);
      System.out.println(base + "^" + exponent + " = " + power);
    }
  }
}
