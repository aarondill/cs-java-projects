import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Primary java class: Patryk
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
public class Patryk {
  private static String rev(String s) {
    return new StringBuilder(s).reverse().toString();
  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Patryk.class.getResourceAsStream("./patryk.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      List<String> nums = new ArrayList<String>();
      for (int i = 0; i < dataCount; i++)
        nums.add(dataScanner.next());
      nums.sort((x, y) -> rev(x).compareTo(rev(y)));
      nums.stream().forEach(System.out::println);
    }

  }
}
