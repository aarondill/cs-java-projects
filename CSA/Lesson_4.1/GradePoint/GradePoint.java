import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Primary java class: GradePoint
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/02/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Write a program that requires the user to enter exactly 7
 * letter grades, A, B, C, D, or F. The program should then calculate a grade
 * point
 * average using the following scale.
 * A = 4.0
 * B = 3.0
 * C = 2.0
 * D = 1.0
 * F = 0.0
 * The program should print the grade point average rounded to 2 decimal
 * places. (Hint: You will be using else if statements and (int)(x + 0.5) will
 * round x to a whole number.)
 *
 */
public class GradePoint {
  static Map<Character, Double> weights = new HashMap<>();
  static {
    weights.put('A', 4.0);
    weights.put('B', 3.0);
    weights.put('C', 2.0);
    weights.put('D', 1.0);
    weights.put('F', 0.0);
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.println("Enter seven letter grades (A,B,C,D or F)");
      double count = 7;
      double sum = 0;
      for (int i = 0; i < count;) {
        String letterGrade = scan.next().toUpperCase(); // Allow lowercase letters
        // Be nice to the user: allow mutiple grades without spaces in between
        for (char g : letterGrade.toCharArray()) {
          if (!weights.containsKey(g)) {
            System.err.println("Invalid letter grade: " + g);
            System.exit(1);
            return;
          }
          sum += weights.get(g);
          i++;
        }
      }
      double average = (int) ((sum / count * 100) + 0.5) / 100.0; // Round. It won't let me use Math.round(double)
      System.out.println("GPA = " + average);

    }
  }
}
