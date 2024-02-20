import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Primary java class: CountingByTwos
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/02/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * print every other number from 2 to 20 all on the same line. You must use a
 * while loop
 */
public class CountingByTwos {
  public static void main(String... args) {
    int start = 2, end = 20;

    ArrayList<Integer> nums = new ArrayList<>();
    int i = start;
    while (i <= end) {
      nums.add(i);
      i += 2;
    }
    // No trailing spaces :)
    String out = nums.stream().map(x -> x.toString()).collect(Collectors.joining(" "));
    System.out.println(out);
  }
}
