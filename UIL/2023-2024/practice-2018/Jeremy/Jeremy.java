import java.util.Scanner;

/**
 * Primary java class: Jeremy
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
public class Jeremy {
  public static void main(String... args) {
    try (Scanner scan = new Scanner(Jeremy.class.getResourceAsStream("./jeremy.dat"))) {
      int N = scan.nextInt();
      for (int i = 0; i < N; i++) {
        System.out.println(scan.nextInt());
      }
    }

  }
}
