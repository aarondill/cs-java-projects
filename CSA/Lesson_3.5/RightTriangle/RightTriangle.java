import java.util.Scanner;

/**
 * Primary java class: RightTriangle
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    10/23/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Given the side lengths of a triangle, determine if the triangle is a valid
 * triangle. If the triangle is a valid triangle, determine if the triangle is a
 * right triangle.
 * Triangle facts: The triangle inequality theorem states that the sum of any
 * two sides of a triangle must be greater than the third side to be a triangle.
 * Test this first to verify that the given sides form a triangle. Use the
 * Pythagorean Theorem to determine if a valid triangle is right or not. If 𝑎2
 * + 𝑏2 = 𝑐2, then the triangle is a right triangle. Use nested if else
 * statements in this program. Be sure to thoroughly test your program.
 * Do not assume that the sides are entered in any particular order.
 *
 */
public class RightTriangle {
  public static void main(String... args) {
    int a, b, c;
    if (args.length > 0) {
      if (args.length < 3)
        throw new IllegalArgumentException("Invalid number of arguments. Expected 3, got " + args.length + ".");
      a = Integer.parseInt(args[0]);
      b = Integer.parseInt(args[1]);
      c = Integer.parseInt(args[2]);
    } else {
      try (Scanner scanner = new Scanner(System.in)) {
        System.out.print("Enter three integer sides of a triangle: ");
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
      }
    }

    System.out.printf("The side lengths of %d, %d, and %d ", a, b, c);
    int min = Math.min(a, Math.min(b, c));
    int mid = Math.max(Math.min(a, b), Math.min(Math.max(a, b), c));
    int max = Math.max(a, Math.max(b, c));
    if (min + mid <= max) {
      System.out.println("do not form a triangle.");
    } else if (min * min + mid * mid == max * max) {
      System.out.println("form a right triangle.");
    } else {
      System.out.println("form a triangle, but is not a right triangle.");
    }

  }
}
