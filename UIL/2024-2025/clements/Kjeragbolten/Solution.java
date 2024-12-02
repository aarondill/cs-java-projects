import java.util.Arrays;
import java.util.Scanner;

public class Solution {
  @SuppressWarnings("unused")
  private static int caseNum = 1;

  private static void each(Scanner scan) {
    /**
     * The Boulder is the ellipsoid with the equation
     *
     * <pre>
     *  x²    y²    z²
     * --- + --- + --- = 1
     *  A²    B²    C²
     * </pre>
     */
    double A = scan.nextInt();
    double B = scan.nextInt();
    double C = scan.nextInt();
    scan.nextLine();
    /**
     * Each Cliff is a plane with the equation
     *
     * <pre>
     * xxᵢ   yyᵢ   zzᵢ
     * --- + --- + --- = 1
     *  A²    B²    C²
     * </pre>
     */
    double x1 = scan.nextInt();
    double y1 = scan.nextInt();
    double z1 = scan.nextInt();
    scan.nextLine();
    double x2 = scan.nextInt();
    double y2 = scan.nextInt();
    double z2 = scan.nextInt();
    if (scan.hasNextLine()) scan.nextLine();

    double i1 = x1 / A;
    double j1 = y1 / B;
    double k1 = z1 / C;

    double i2 = x2 / A;
    double j2 = y2 / B;
    double k2 = z2 / C;

    double[] cross1 = cross(i1, j1, k1, i2, j2, k2);
    double a1 = cross1[0];
    double b1 = cross1[1];
    double c1 = cross1[2];

    double d = Math.sqrt(s(a1) + s(b1) + s(c1));
    double t = i2 / i1;
    double y = (t - 1) / (j1 * t - j2);
    double u = j2 / j1;
    double x = (u - 1) / (i1 * u - i2);
    System.out.println((i1 + " " + u + " " + i2));

    double i3 = -x;
    double j3 = -y;
    double k3 = -C;
    double[] cross2 = cross(i3, j3, k3, a1, b1, c1);

    double d2 = Math.sqrt(s(cross2[0]) + s(cross2[1]) + s(cross2[2]));
    System.out.printf("Case #%d: %.6f%n", caseNum, d2 / d);
  }

  private static double[] cross(double x1, double y1, double z1, double x2, double y2, double z2) {
    double a1 = y1 * z2 - y2 * z1;
    double b1 = x1 * z2 - x2 * z1;
    double c1 = x1 * y2 - x2 * y1;
    return new double[] {a1, b1, c1};
  }

  private static double s(double x) {
    return x * x;
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        each(scan);
    }
  }
}
