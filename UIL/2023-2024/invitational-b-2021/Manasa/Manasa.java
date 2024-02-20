import java.util.Scanner;

/**
 * Primary java class: Manasa
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
public class Manasa {
  /**
   * @param V swimming velocity (m/s)
   * @param T swimming time before stopping (sec)
   * @param W speed of river in opposite direction (m/s)
   * @param S resting time (sec)
   * @param D distance to destination (m)
   * @return An integer representing the number of times she must start swimming,
   *         or null if impossible.
   */
  private static Integer test(int V, int T, int W, int S, int D) {
    if (D <= V * T) return 1; // She can reach the destination the first time
    // The distance traveled each time she starts swimming until the next time she starts swimming (including river flow).
    int distancePerTime = (V * T) - (W * S);
    if (distancePerTime <= 0) return null; // Impossible to reach the destination bc she loses distance
    return (D / distancePerTime) + 1; // she must swim at least once

  }

  public static void main(String... args) {
    try (Scanner dataScanner =
        new Scanner(Manasa.class.getResourceAsStream("./" + Manasa.class.getName().toLowerCase() + ".dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        int V = dataScanner.nextInt();
        int T = dataScanner.nextInt();
        int W = dataScanner.nextInt();
        int S = dataScanner.nextInt();
        int D = dataScanner.nextInt();
        if (V <= 0 || T <= 0 || W <= 0 || S <= 0 || D <= 0)
          throw new IllegalArgumentException("All values are defined as > 0");
        var testResult = test(V, T, W, S, D);
        System.out.printf("Case #%d: %s\n", i + 1, testResult != null ? testResult : "Impossible");
      }
    }
  }
}
