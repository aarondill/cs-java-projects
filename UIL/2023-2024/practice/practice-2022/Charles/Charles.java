import java.util.ArrayList;
import java.util.Scanner;

/**
 * Primary java class: Charles
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    01/29/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Charles {
  public static ArrayList<Integer> factors(int n) {
    ArrayList<Integer> factors = new ArrayList<>();
    for (int i = 1; i <= (n); i++) {
      if (n % i == 0) factors.add(i);
    }
    return factors;
  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Charles.class.getResourceAsStream("./charles.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        int num = dataScanner.nextInt();
        var factors = factors(num);
        System.out.print('1');
        int sum = 0;
        for (int factor : factors) {
          sum += factor;
          if (factor != 1) System.out.print("+" + factor);
        }
        System.out.println("=" + sum);
      }
    }
  }
}
