import java.util.Scanner;

/**
 * Primary java class: SlopeOfALine
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    10/19/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 * Lab 3.3.1 –SlopeOfALine - Write a program that will allow the user to enter
 * an four int values, x1, y1, x2, and y2, that represent two points on a line.
 * If the line is not a vertical line, calculate and print the slope of the
 * line. If the line is vertical, output a statement stating that the line is a
 * vertical line and the slope is undefined.
 * 
 */
public class SlopeOfALine {
  private static int getInt(String prompt, Scanner scan) {
    System.out.print(prompt);
    return scan.nextInt();
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      int x1 = getInt("Enter x1: ", scan);
      int y1 = getInt("Enter y1: ", scan);
      int x2 = getInt("Enter x2: ", scan);
      int y2 = getInt("Enter y2: ", scan);
      System.out.printf("The line defined by the points (%d, %d) and (%d, %d)", x1, y1, x2, y2);
      if (x1 == x2) {
        System.out.println(" is a vertical line and the slope is undefined.");
      } else {
        double slope = (double) (y2 - y1) / (double) (x2 - x1); // floating point division!
        System.out.println(" has a slope of " + slope + '.');
      }

    }
  }
}
