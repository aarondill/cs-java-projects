import java.util.Scanner;

/**
 * Primary java class: FindLarge
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    10/13/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Lab 3.2.2 –FindLarge - Write a program that will allow the user to input two
 * numeric values and output which value is the larger of the two. If the two
 * numbers are the same, then the output should reflect that they are equal.
 *
 * 
 */
public class FindLarge {
  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("Enter the first number: ");
      int a = scan.nextInt();
      System.out.print("Enter the second number: ");
      int b = scan.nextInt();
      if (a > b) {
        System.out.printf("%d is larger than %d.\n", a, b);
      } else if (a < b) {
        System.out.printf("%d is larger than %d.\n", b, a);
      } else {
        System.out.printf("%d and %d are equal.\n", a, b);
      }

    }

  }
}
