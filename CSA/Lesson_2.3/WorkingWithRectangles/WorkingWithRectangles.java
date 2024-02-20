import java.util.Scanner;
import java.awt.Rectangle;

/**
 * public class WorkingWithRectangles
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    09/13/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class WorkingWithRectangles {
  public static void main(String... args) {
    try (Scanner kb = new Scanner(System.in)) {
      // System.out.print("Enter the width: ");
      // int w = kb.nextInt();
      // System.out.print("Enter the height: ");
      // int h = kb.nextInt();
      // Rectangle r1 = new Rectangle(w, h);
      // System.out.println("Width = " + r1.getWidth());
      // System.out.println("Height = " + r1.getHeight());
      // double area = r1.getWidth() * r1.getHeight();
      // System.out.println("Area = " + area);

      Rectangle r2 = new Rectangle();
      r2.setSize(3, 2);
      System.out.println("x = " + r2.getX());
      System.out.println("y = " + r2.getY());
      r2.setLocation(1, 3);
      System.out.println("x = " + r2.getX());
      System.out.println("y = " + r2.getY());
      System.out.println(r2.contains(1, 3));
    }
  }
}
