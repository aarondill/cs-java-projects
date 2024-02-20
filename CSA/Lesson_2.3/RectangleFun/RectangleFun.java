import java.util.Scanner;
import java.awt.Rectangle;

/**
 * Primary java class: RectangleFun
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    09/13/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program that will allow the user to enter the width,
 * height, and the coordinates for the location of a rectangle. The program
 * should then calculate and print the perimeter of the rectangle. After
 * printing the perimeter, move the rectangle 4 units to the left and 2 units up
 * and print the new location. The prompts and the labels for the output should
 * appear exactly like those shown in the sample run shown below. You are
 * required to use method calls for all calculations and output. DO NOT use the
 * variables used to gather data from the user for calculations and output
 *
 */
public class RectangleFun {
  private static int getInt(String p, Scanner s) {
    System.out.print(p);
    if (!s.hasNextInt()) throw new RuntimeException("Make sure your input is valid.");
    if (System.console() == null) System.out.println();
    return s.nextInt();
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      int width = getInt("Width: ", scan);
      int height = getInt("Height: ", scan);
      int x = getInt("X: ", scan);
      int y = getInt("Y: ", scan);
      Rectangle r = new Rectangle(x, y, width, height);
      System.out.println("Perimeter: " + (r.getWidth() * 2 + r.getHeight() * 2));
      r.setLocation((int) r.getX() - 4, (int) r.getY() + 2);
      System.out.println("New location is (" + r.getX() + "," + r.getY() + ")");

    }
  }
}
