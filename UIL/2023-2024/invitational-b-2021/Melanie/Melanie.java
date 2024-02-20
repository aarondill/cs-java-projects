import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Primary java class: Melanie
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
public class Melanie {
  private static long fact(long n) {
    long result = 1;
    for (long i = 1; i <= n; i++) {
      result *= i;
    }
    return result;
  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Melanie.class.getResourceAsStream("./melanie.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        String word = dataScanner.nextLine();
        int count = word.length();
        Map<Character, Integer> non_unique = new HashMap<>();
        for (char c : word.toCharArray())
          non_unique.put(c, non_unique.getOrDefault(c, 0) + 1);
        long variations = fact(count);
        for (Map.Entry<Character, Integer> entry : non_unique.entrySet())
          variations /= fact(entry.getValue());
        System.out.println(variations);
      }
    }
  }
}
