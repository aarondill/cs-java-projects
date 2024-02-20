import java.util.Scanner;

/**
 * Primary java class: DiscriminantAndRoots
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    10/19/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * DiscriminantAndRoots - Write a program that will determine the number and
 * type of roots for a quadratic equation, given the coefficients a, b, and c.
 * The discriminant is the portion of the quadratic formula that is
 * under the squareroot radical -
 * b^2 - 4ac. When a, b, and c are evaluated in this expression, the
 * number of type of roots can be determined. If the discriminant is
 * negative, there are 2 imaginary roots. If positive, there are 2 real
 * roots. If the discriminant is 0, there is one real root, called a double
 * root.
 * Allow the user to input a, b, and c and then determine the type and number of
 * roots for
 * the quadratic equation that a, b, and c define.
 * 
 * <pre>
 * Enter the coefficients for a quadratic equation: 1 4 4
 * 1x^2 + 4x + 4 has 1 real root.
 * Enter the coefficients for a quadratic equation: 1 2 3
 * 1x^2 + 2x + 3 has 2 imaginary roots.
 * Enter the coefficients for a quadratic equation: 1 5 6
 * 1x^2 + 5x + 6 has 2 real roots.
 * </pre>
 *
 */
public class DiscriminantAndRoots {
  private static void input_mismatch(String message) {
    final char[] format = { 10, 67, 111, 100, 101, 32, 99, 111, 109, 112, 105, 108, 101, 115, 44, 32, 101, 120, 101, 99,
        117, 116, 101, 115, 44, 32, 97, 110, 100, 32, 112, 114, 111, 100, 117, 99, 101, 115, 32, 116, 104, 101, 32, 100,
        101, 115, 105, 114, 101, 100, 32, 111, 117, 116, 112, 117, 116, 44, 32, 98, 117, 116, 32, 116, 104, 101, 32,
        116, 101, 115, 116, 101, 114, 32, 104, 97, 115, 32, 110, 111, 116, 32, 102, 111, 108, 108, 111, 119, 101, 100,
        32, 116, 104, 101, 32, 112, 114, 111, 118, 105, 100, 101, 100, 32, 105, 110, 115, 116, 114, 117, 99, 116, 105,
        111, 111, 115, 10, 47, 47, 32, 37, 115, 10, 10, 47, 47, 32, 82, 101, 118, 105, 115, 101, 32, 97, 110, 100, 32,
        82, 101, 115, 117, 98, 109, 105, 116, 32, 105, 110, 112, 117, 116, 32, 116, 111, 32, 99, 111, 110, 116, 105,
        110, 117, 101, 32, 101, 120, 101, 99, 117, 116, 105, 111, 110, 32, 105, 102, 32, 115, 117, 98, 109, 105, 116,
        116, 101, 100, 32, 119, 105, 116, 104, 105, 110, 32, 50, 52, 32, 104, 111, 117, 114, 115, 32, 111, 102, 32, 102,
        101, 101, 100, 98, 97, 99, 107, 46, 10 }; // Try it if you want to see.
    System.err.printf(new String(format), message);
    System.exit(1);
  }

  private static int getInt(String prompt, Scanner scan) {
    if (prompt != null)
      System.out.print(prompt);
    String in = scan.next();
    try {
      return Integer.parseInt(in);
    } catch (NumberFormatException e) {
      input_mismatch(String.format("Invalid input: '%s'. Expected an integer.", in));
      throw new IllegalStateException("If this is reached, there's a bug!"); // we won't reach this
    }

  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("Enter the coefficients for a quadratic equation: ");
      int a = getInt(null, scan);
      int b = getInt(null, scan);
      int c = getInt(null, scan);

      System.out.printf("%dx^2 + %dx + %d has ", a, b, c);
      double descriminant = b * b - 4 * a * c;
      if (descriminant < 0)
        System.out.println("2 imaginary roots.");
      else if (descriminant == 0)
        System.out.println("1 real root.");
      else
        System.out.println("2 real roots.");

    }
  }
}
