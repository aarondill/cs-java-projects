import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Primary java class: Krish
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
public class Krish {
  private static void each(int num) {
    String numStr = Integer.toString(Math.abs(num), 10);
    List<Integer> intDigits = numStr.chars().map(x -> Integer.parseInt(String.valueOf((char) x), 10)).boxed().toList();
    boolean neg = num < 0;

    ArrayList<String> output = new ArrayList<>();
    output.add(Integer.toString(num));// original number
    output.add((neg ? -1 : 1) * intDigits.stream().reduce(0, (x, a) -> x + a) + "");// sum of digits
    output.add((neg ? -1 : 1) * intDigits.stream().filter(x -> x != 0).reduce(1, (x, a) -> x * a) + ""); // product of non-zero digits
    long reversed = (neg ? -1 : 1)
        * Long.parseLong(intDigits.reversed().stream().map(String::valueOf).collect(Collectors.joining("")), 10);
    output.add(Long.toString(reversed, 10)); // reverse digits
    output.add(Long.toString(reversed * num, 10)); // product of original and reversed

    System.out.println(String.join(" ", output.toArray(String[]::new)));
  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Krish.class.getResourceAsStream("./krish.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        int num = dataScanner.nextInt();
        dataScanner.nextLine();
        each(num);
      }
    }
  }
}
