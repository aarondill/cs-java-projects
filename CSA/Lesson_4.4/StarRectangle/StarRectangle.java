import java.util.Scanner;

/**
 * Primary java class: StarRectangle
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/13/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * This program inputs the side lengths and
 * outputs a square and/or rectangle of stars
 *
 */

public class StarRectangle {
  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("Enter a number: ");
      int num1 = scan.nextInt();
      System.out.print("Enter a number: ");
      int num2 = scan.nextInt();
      System.out.println("This is a " + num1 + " by " + num2 + " rectangle of stars:");
      for (int i = 1; i <= num1; i++) {
        for (int j = 1; j <= num2; j++) {
          System.out.print("*");
        }
        System.out.println();
      }
    }
  }
}
