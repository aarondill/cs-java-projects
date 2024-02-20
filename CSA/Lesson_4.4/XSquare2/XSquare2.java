import java.util.Scanner;

/**
 * Primary java class: XSquare2
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/13/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Write a program that will prompt the user for a number n. Have the program
 * print a n x n square of capital X.
 *
 */
public class XSquare2 {
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

    for (int i = 0; i < n; i++) {
      // OR skip the loop: System.out.println("X".repeat(n));
      for (int j = 0; j < n; j++) {
        System.out.print("X");
      }
      System.out.println();
    }

  }
}
