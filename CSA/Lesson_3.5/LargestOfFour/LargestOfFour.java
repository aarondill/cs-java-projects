import java.util.Scanner;

/**
 * Primary java class: LargestOfFour
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    10/23/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Write a program that will ask the user to input four integers and then will
 * output which value is the largest value. You must use one nested if else
 * structure to determine the largest value. Be sure to test your program
 * thoroughly
 *
 */
public class LargestOfFour {
  public static void main(String... args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Enter 4 integer values: ");
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int c = scanner.nextInt();
      int d = scanner.nextInt();
      // The only sane implementation: Math.max(a, Math.max(b, Math.max(c, d)));
      int max;
      if (a > b) { // A is max
        if (a > c) {
          if (a > d) {
            max = a;
          } else {
            max = d;
          }
        } else {
          if (c > d) {
            max = c;
          } else {
            max = d;
          }
        }
      } else if (b > c) { // B is max
        if (b > d) {
          max = b;
        } else {
          max = d;
        }
      } else if (c > d) {
        max = c;
      } else {
        max = d;
      }

      System.out.printf("The largest value of %d, %d, %d, and %d is %d.\n", a, b, c, d, max);
    }
  }
}
