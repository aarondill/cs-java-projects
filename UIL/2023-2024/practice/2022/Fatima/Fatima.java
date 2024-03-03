import java.util.ArrayList;
import java.util.Scanner;

/**
 * Primary java class: Fatima
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
public class Fatima {
  private static double HI(double h, double t) {
    return -42.379 + 2.04901523 * t + 10.14333127 * h - 0.22475541 * t * h - 6.83783 * 0.001 * Math.pow(t, 2)
        - 5.481717 * 0.01 * Math.pow(h, 2) + 1.22874 * 0.001 * Math.pow(t, 2) * h + 8.5282 * 0.0001 * t * Math.pow(h, 2)
        - 1.99 * Math.pow(10, -6) * Math.pow(t, 2) * Math.pow(h, 2);
  }

  private static double ADJUSTMENT(double h, double t) {
    return ((h - 85.0) / 10) * ((87.0 - t) / 5.0);
  }

  private static void forEachLine(double x, double y) {
    ArrayList<Double> tempList = new ArrayList<>();
    ArrayList<Double> humidList = new ArrayList<>();
    for (double t = 80; t <= 125; t += x)
      tempList.add(t);
    for (double t = 20; t <= 100; t += y)
      humidList.add(t);
    System.out.print("Temp   ");
    for (double t : tempList)
      System.out.printf("%-6.1f", t);
    System.out.println();
    System.out.println("Humid " + "=".repeat(95));
    for (double h : humidList) {
      System.out.printf("%5.1f  ", h);
      for (double t : tempList) {
        double hi = HI(h, t);
        if (h > 85) hi += ADJUSTMENT(h, t);
        if (hi < 140) System.out.printf("%-6.1f", hi);
      }
      System.out.println();
    }
    System.out.println("=".repeat(30));

  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Fatima.class.getResourceAsStream("./fatima.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        double x = dataScanner.nextDouble();
        double y = dataScanner.nextDouble();
        forEachLine(x, y);
      }
    }
  }
}
