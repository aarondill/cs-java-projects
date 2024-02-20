import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Primary java class: Hiro
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
public class Hiro {
  static Map<Character, Integer> m = new HashMap<>();
  static {
    m.put('I', 1);
    m.put('V', 5);
    m.put('X', 10);
    m.put('L', 50);
    m.put('C', 100);
    m.put('D', 500);
    m.put('M', 1000);
  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Hiro.class.getResourceAsStream("./hiro.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        char[] chars = dataScanner.nextLine().toCharArray();

        int sum = 0;
        for (int j = 0; j < chars.length; j++) {
          int c = m.get(chars[j]);
          if (j < chars.length - 1) {
            int next = m.get(chars[j + 1]);
            if (c < next) {
              sum += next - c;
              j++;
            } else sum += c;
          } else sum += c;
        }
        System.out.println(sum);

      }
    }

  }
}
