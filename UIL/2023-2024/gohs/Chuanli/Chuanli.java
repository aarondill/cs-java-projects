import java.util.Scanner;

/**
 * Primary java class: Chuanli
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
public class Chuanli {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Chuanli.class.getResourceAsStream("./chuanli.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        String line = dataScanner.nextLine();
        System.out.println(new StringBuilder(line).reverse().toString());
      }
    }
  }
}
