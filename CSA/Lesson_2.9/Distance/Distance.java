import java.util.Scanner;

/**
 * Primary java class: Distance
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    09/25/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Lab 2.9.3 - Distance – Use what you have learned in math class or a textbook
 * or the Internet to find the formula to determine the distance between two
 * points. Before you write the program, calculate the distance between two
 * different pairs of points of your own choosing. Then write a program that
 * will allow the user to enter the coordinates of two points. The program
 * should then calculate and print the distance between those two points. You
 * must use all Math class methods to perform the calculations. Test your
 * program using the values you calculated for the points that you chose before
 * you began to code. Format the prompts and the output just as you see in this
 * sample run.
 * 
 * <pre>
 * Enter the coordinates of the first point (x1,y1): 2 -3
 * Enter the coordinates of the second point (x2,y2): -4 1
 * The distance between (2,-3) and (4,-1) is 7.211102550927978
 * </pre>
 *
 */
public class Distance {
  public static void main(String... args) {
    try (Scanner input = new Scanner(System.in)) {
      System.out.print("Enter the coordinates of the first point (x1,y1): ");
      int x1 = input.nextInt();
      int y1 = input.nextInt();
      System.out.print("Enter the coordinates of the second point (x2,y2): ");
      int x2 = input.nextInt();
      int y2 = input.nextInt();
      System.out.println("The distance between (" + x1 + "," + y1 + ") and (" + x2 + "," + y2 + ") is "
          + Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
    }
  }
}
