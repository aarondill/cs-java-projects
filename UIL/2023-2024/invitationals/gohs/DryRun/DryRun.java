import java.util.Scanner;

/**
 * Primary java class: DryRun
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/03/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class DryRun {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(DryRun.class.getResourceAsStream("./dryrun.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        System.out.printf("I like %s.\n", dataScanner.nextLine());
      }
    }
  }
}
