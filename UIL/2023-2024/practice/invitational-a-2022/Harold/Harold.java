import java.util.Scanner;

/**
 * Primary java class: Harold
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/02/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Harold {
  private static void each(int num) {
    double tensPower = Math.floor(Math.log10(num));
    double sciNumber = num / Math.pow(10, tensPower);
    if (sciNumber % 1 == 0) System.out.printf("%d=%.0f*10^%.0f\n", num, sciNumber, tensPower);
    else System.out.printf("%d=%s*10^%.0f\n", num, sciNumber, tensPower);
  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Harold.class.getResourceAsStream("./harold.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        each(dataScanner.nextInt());
      }
    }
  }
}
