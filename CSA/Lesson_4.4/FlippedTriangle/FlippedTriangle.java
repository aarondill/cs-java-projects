import java.util.Scanner;

/**
 * Primary java class: FlippedTriangle
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/13/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Write a program that will prompt the user for a value n. Print n rows of
 * asterisks (*) where the first row has n asterisks and each subsequent row has
 * one less asterisk
 *
 */
public class FlippedTriangle {
  public static void main(String... args) {
    int n;
    if (args.length > 0) {
      n = Integer.parseInt(args[0]);
    } else {
      try (Scanner scan = new Scanner(System.in)) {
        System.out.print("Enter n: ");
        n = scan.nextInt();
      }
    }

    for (int x = 0; x < n; x++) {
      // OR skip the loop: System.out.println("X".repeat(n - x));
      for (int y = 0; y < n - x; y++) {
        System.out.print("X");
      }
      System.out.println();
    }
  }
}
