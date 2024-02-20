import java.util.Scanner;

/**
 * Primary java class: Power
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/06/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Write a program that asks the user for two whole numbers that represent a
 * base and an exponent. Print the value of the base raised to the power of the
 * exponent. For example, if the user enters 3 and 4, then print the value of
 * 34. In this case 3*3*3*3 which is 81. DO NOT use Math.pow(x,y). For this
 * problem you may assume no power will exceed Integer.MAX_VALUE and the
 * exponent will always be positive. The user may enter a negative base
 *
 */
public class Power {
  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("Enter the base: ");
      int base = scan.nextInt();
      System.out.print("Enter the exponent: ");
      int exponent = scan.nextInt();
      int value = exponent == 0 ? 1 : base;
      for (int i = 1; i < exponent; i++) {
        value *= base;
      }
      System.out.println(base + " ^ " + exponent + " = " + value);

    }
  }
}
