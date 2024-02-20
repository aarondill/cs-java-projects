import java.util.Arrays;
import java.util.Scanner;

/**
 * Primary java class: Arthur
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    12/04/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Arthur {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Arthur.class.getResourceAsStream("./arthur.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        int a = dataScanner.nextInt();
        int b = dataScanner.nextInt();
        int c = dataScanner.nextInt();
        boolean pythag = false;
        if (a * a + b * b == c * c) pythag = true;
        if (a * a == b * b + c * c) pythag = true;
        if (b * b == a * a + c * c) pythag = true;
        int[] data = new int[] {a, b, c};
        Arrays.sort(data);

        if (pythag) System.out.printf("%d, %d, %d is a Pythagorean triple.\n", data[0], data[1], data[2]);
        else System.out.printf("%d, %d, %d is not a Pythagorean triple.\n", data[0], data[1], data[2]);
      }
    }
  }
}
