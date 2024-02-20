import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Primary java class: Tom
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
public class Tom {
  public static void main(String... args) {
    //     Input: Input will begin with a single integer T, the number of test cases to follow. The following T lines each contain a single
    // word consisting of only lowercase characters a-z.
    try (Scanner scan = new Scanner(Tom.class.getResourceAsStream("./tom.dat"))) {
      int t = scan.nextInt();
      scan.nextLine();
      for (int i = 0; i < t; i++) {
        String s = scan.nextLine();
        // count letter frequency
        Map<Character, Integer> map = new HashMap<>();
        int sum = s.chars().map(c -> {
          map.put((char) c, map.getOrDefault((char) c, 0) + 1);
          return map.get((char) c);
        }).sum();
        System.out.println(sum);

      }
    }
  }
}
