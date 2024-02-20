import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Primary java class: Kinga
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    10/20/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Kinga {
  private static void header(int count) {
    System.out.print("  ");
    for (char i = 'A'; i < 'A' + count; i++) {
      System.out.print(i);
      if (i < 'A' + count - 1)
        System.out.print(" | ");
    }
    System.out.println();
  }

  private static void print_array(Boolean[] bools, int index) {
    System.out.print(index + " ");
    System.out.println(Stream.of(bools).map(b -> b ? "1" : "0").collect(Collectors.joining(" | ")));

  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(Kinga.class.getResourceAsStream("./kinga.dat"))) {
      while (scan.hasNextInt()) {
        int count = scan.nextInt();
        Boolean[] bools = new Boolean[count];
        for (int i = 0; i < bools.length; i++)
          bools[i] = false;

        header(count);
        int index = 0;
        for (int i = 0; i < bools.length; i++) {
          for (int j = 0; j < bools.length; j++) {
            index++;
            print_array(bools, index);
          }
        }
        System.out.println("=====");
      }
    }
  }
}
