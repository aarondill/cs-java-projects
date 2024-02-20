import java.util.Scanner;

/**
 * Primary java class: Candela
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    10/20/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Candela {
  public static void main(String... args) {
    try (Scanner scan = new Scanner(Candela.class.getResourceAsStream("./candela.dat"))) {
      int Q = scan.nextInt();
      for (int i = 0; i < Q; i++) {
        int P = scan.nextInt();
        int D = scan.nextInt();

      }
      while (scan.hasNextInt()) {
        int target = scan.nextInt();
      }

    }

  }
}
