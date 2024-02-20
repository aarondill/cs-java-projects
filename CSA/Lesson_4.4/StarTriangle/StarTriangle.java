import java.util.Scanner;

/**
 * Primary java class: StarTriangle
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/13/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * This program inputs the side length and outputs an isosceles triangle of
 * stars
 *
 */
public class StarTriangle {
  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("Enter a number: ");
      int side = scan.nextInt();
      System.out.println("This is a " + side + " by " + side + " triangle of stars:");
      for (int i = 1; i <= side; i++) {
        for (int j = 1; j <= i; j++) {
          System.out.print("*");
        }
        System.out.println();
      }
    }
  }
}
