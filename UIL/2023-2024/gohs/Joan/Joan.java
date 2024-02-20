import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Primary java class: Joan
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
public class Joan {
  public static void main(String... args) {
    List<String> words = new ArrayList<String>();
    try (Scanner scan = new Scanner(Joan.class.getResourceAsStream("./joan.dat"))) {
      while (scan.hasNext())
        words.add(scan.next());
    }
    System.out.printf("%d words with an average length of %.0f letters\n", words.size(),
        words.stream().mapToInt(s -> s.length()).average().getAsDouble());
  }
}
