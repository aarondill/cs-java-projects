import java.util.Scanner;
import java.util.function.Supplier;

/**
 * public class PointsAndRectangles
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    09/11/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: allow the user to enter the coordinates of the top left
 * corner of a rectangle and its length and width. The program should then
 * declare a Point object using the coordinates for the top left corner using
 * those values entered by the user. Next, instantiate a Dimension object using
 * the length and width entered by the user. Use the Point and Dimension objects
 * to instantiate a Rectangle object representing the rectangle and its
 * location. Finally, print the Point object, Dimension object and the Rectangle
 * object. A sample run is shown below.
 * 
 * <pre>
 * Enter the x coordinate: 1
 * Enter the y coordinate: 5
 * Enter the length: 5
 * Enter the width: 6
 * java.awt.Point [×=1,y=5]
 * java.awt.Dimension[width=5,height=6]
 * java.awt.Rectangle [×=1,y=5,width=5, height=6]
 * </pre>
 */
public class PointsAndRectangles {
  private static <T> T getInput(String promptVal, Supplier<T> get, Supplier<Boolean> has) {
    System.out.print(String.format("Enter the %s: ", promptVal));
    if (has.get()) {
      if (System.console() == null) System.out.println();
      T input = get.get();
      return input;
    }
    throw new RuntimeException("Please ensure input is valid.");
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      int x = getInput("x coordinate", scan::nextInt, scan::hasNextInt);
      int y = getInput("y coordinate", scan::nextInt, scan::hasNextInt);
      int length = getInput("length coordinate", scan::nextInt, scan::hasNextInt);
      int width = getInput("width coordinate", scan::nextInt, scan::hasNextInt);
      java.awt.Point p = new java.awt.Point(x, y);
      java.awt.Dimension d = new java.awt.Dimension(length, width);
      java.awt.Rectangle r = new java.awt.Rectangle(p, d);
      System.out.println(p);
      System.out.println(d);
      System.out.println(r);
    }
  }
}
