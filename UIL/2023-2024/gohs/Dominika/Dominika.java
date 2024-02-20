import java.util.Scanner;

/**
 * Primary java class: Dominika
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
public class Dominika {
  private static void out(double x, double y) {
    System.out.printf("(%.2f,%.2f)\n", x, y);
  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Dominika.class.getResourceAsStream("./dominika.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        System.out.printf("Test case: %d\n", i + 1);
        int x1 = dataScanner.nextInt();
        int y1 = dataScanner.nextInt();
        int x2 = dataScanner.nextInt();
        int y2 = dataScanner.nextInt();

        double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double xm = (x2 + x1) / 2.0;
        double ym = (y2 + y1) / 2.0;

        double xf, yf;
        if (y2 - y1 == 0) {
          xf = xm;
          yf = Math.sqrt(Math.pow(d, 2) - (Math.pow(d, 2) / 4));
          out(xf, ym - yf);
          out(xf, ym + yf);
          continue;
        } else if (x2 - x1 == 0) {
          yf = ym;
          xf = Math.sqrt(Math.pow(d, 2) - (Math.pow(d, 2) / 4));
          out(xm - xf, yf);
          out(xm + xf, yf);
          continue;
        }
        double slope = -1 / ((double) (y2 - y1) / (x2 - x1));
        xf = Math.sqrt(Math.pow(Math.sqrt(3) * d / 2.0, 2) / (Math.pow(slope, 2) + 1));
        yf = slope * xf;
        out(xm - xf, ym - yf);
        out(xm + xf, ym + yf);

        // TWO: 
        // double df = d / 2.0;
        // double xf = x2 + df;
        // double hf = df * Math.sqrt(3);
        // double yf = y2 + hf;

        // ONE: 
        // double xm = (x2 - x1) / 2.0;
        // double ym = (y2 - y1) / 2.0;
        // double slope = -1 / ((double) (y2 - y1) / (x2 - x1));
        // double b = ym - slope * xm;
        // double a = Math.pow(d, 2) * Math.sqrt(3) / 4;
        // double xf = (a * 2 - (x1 + x2) * b) / (slope * (x1 + x2) - y1 * y2);
        // System.out.printf("xf: %-28s yf: %s\n", xf, yf);

      }
    }
  }
}
