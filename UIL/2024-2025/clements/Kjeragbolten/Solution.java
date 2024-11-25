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
    long A = scan.nextInt();
    long B = scan.nextInt();
    long C = scan.nextInt();
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
    long x1 = scan.nextInt();
    long y1 = scan.nextInt();
    long z1 = scan.nextInt();
    scan.nextLine();
    long x2 = scan.nextInt();
    long y2 = scan.nextInt();
    long z2 = scan.nextInt();
    if (scan.hasNextLine()) scan.nextLine();

    // TODO: Find value of z for boulder. x=0, y=0
    // z = C*√(−x²*B²−y²*A²+A²*B²)/AB
    int x = 0;
    int y = 0;
    double boulderZ = C * Math.sqrt(-s(x) * s(B) - s(y) * s(A) + s(A) * s(B)) / A * B;

    // TODO: Find value of z for cliff intersection. (x=0, y=0)?
    // z = −C²*x*xi/zi*A² − C²*y*yi/zi*B² + C²*zi
    double cliffZ = (-s(C) * x * x1 / z1 * s(A)) - (s(C) * y * y1 / z1 * s(B)) + (s(C) * z1);
    double cliffZ2 = (-s(C) * x * x2 / z2 * s(A)) - (s(C) * y * y2 / z2 * s(B)) + (s(C) * z2);

    System.out.println("Case #" + caseNum + ": " + boulderZ + " " + cliffZ + " " + Math.abs(boulderZ - cliffZ));
    System.out.println("Case #" + caseNum + ": " + boulderZ + " " + cliffZ2 + " " + Math.abs(boulderZ - cliffZ2));

  }

  private static long s(long x) {
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
