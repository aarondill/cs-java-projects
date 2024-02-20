import java.util.Scanner;

/**
 * Primary java class: Bayani
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
public class Bayani {
  public static void main(String... args) {
    try (Scanner scan = new Scanner(Bayani.class.getResourceAsStream("./bayani.dat"))) {
      double total = 0;
      while (scan.hasNextLine()) {
        double expense = Double.parseDouble(scan.nextLine());
        total += expense;
        System.out.format("%7s $%7.2f\n", "", expense);
      }
      System.out.format("Total = $%7.2f\n", total);

    }

  }
}
