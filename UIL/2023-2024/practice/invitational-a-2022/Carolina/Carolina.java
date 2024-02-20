import java.util.Scanner;

/**
 * Primary java class: Carolina
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
public class Carolina {
  private static double tax(double cost) {
    return cost * (8.25 / 100);
  }

  public static void main(String... args) {
    double total = 0;

    try (Scanner dataScanner = new Scanner(Carolina.class.getResourceAsStream("./carolina.dat"))) {
      while (dataScanner.hasNextLine()) {
        double cost = dataScanner.nextDouble();
        String name = dataScanner.nextLine().trim();
        double tax = tax(cost);
        total += tax + cost;
        System.out.println(String.format("$%.2f + $%.2f = $%.2f %s", cost, tax, tax + cost, name));
      }
    }
    System.out.println(String.format("$%.2f Sum of Individual Purchases", total));
  }
}
