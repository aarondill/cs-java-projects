import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Primary java class: Gerald
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
public class Gerald {
  public static void main(String... args) {
    List<Integer> list = new ArrayList<Integer>();
    try (Scanner scan = new Scanner(Gerald.class.getResourceAsStream("./gerald.dat"))) {
      while (scan.hasNextInt())
        list.add(scan.nextInt());
    }
    System.out.println("COUNT:" + list.stream().count());
    System.out.println("SMALLEST:" + list.stream().mapToInt(Integer::intValue).min().getAsInt());
    System.out.println("LARGEST:" + list.stream().mapToInt(Integer::intValue).max().getAsInt());
    System.out.printf("MEAN:%.1f\n", list.stream().mapToInt(Integer::intValue).average().getAsDouble());
  }
}
