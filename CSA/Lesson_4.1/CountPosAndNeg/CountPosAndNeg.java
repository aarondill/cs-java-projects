import java.util.Scanner;

/**
 * Primary java class: CountPosAndNeg
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/02/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Write a program that allows the user to enter both positive and negative
 * numbers until zero has been entered. The program should then report the
 * number of positive values entered and the number of negative values entered.
 *
 */
public class CountPosAndNeg {
  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      int num;
      int neg = 0, pos = 0;
      do {
        System.out.print("Enter a positive or negative number or 0 to quit: ");
        num = scan.nextInt();
        if (num > 0) {
          pos++;
        } else if (num < 0) {
          neg++;
        }
      } while (num != 0);
      System.out.printf("There were %d positive numbers and %d negative numbers.\n", pos, neg);

    }
  }
}
