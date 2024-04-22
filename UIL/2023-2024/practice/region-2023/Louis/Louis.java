import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Louis {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "louis.dat";

  private static String numRoots(double a, double b, double c) {
    double discriminant = b * b - 4 * a * c;
    if (discriminant < 0) {
      return "Function has no roots ";
    } else if (discriminant == 0) {
      return "Function has 1 root at ";
    } else {
      return "Function has 2 roots at ";
    }
  }

  private static double[] findRoots(double a, double b, double c) {
    double descriminate = b * b - 4 * a * c;
    if (descriminate < 0) return new double[0];
    double sqrt = Math.sqrt(descriminate);
    double root1 = (-b + sqrt) / (2 * a);
    double root2 = (-b - sqrt) / (2 * a);
    if (root1 == root2) return new double[] {root1};
    double[] roots = {root1, root2};
    Arrays.sort(roots);
    return roots;
  }

  private static double[] findVertex(double a, double b, double c) {
    double x = -b / (double) (2 * a);
    double y = a * x * x + b * x + c;
    return new double[] {x, y};
  }

  private static void each(Scanner scan) {
    // Parse the input:
    double a = scan.nextDouble(), b = scan.nextDouble(), c = scan.nextDouble();
    scan.nextLine();
    // Handle output:
    if (a == 0) {
      System.out.println("Function is not quadratic");
      return;
    }
    System.out.print(numRoots(a, b, c));
    double[] roots = findRoots(a, b, c);
    if (roots.length > 1) System.out.printf("%.3f and %.3f with ", roots[0], roots[1]);
    else if (roots.length > 0) System.out.printf("%.3f with ", roots[0]);
    else System.out.print("with ");

    if (a > 0) System.out.print("min of ");
    else System.out.print("max of ");
    double[] vertex = findVertex(a, b, c);
    System.out.printf("%.3f at %.3f", vertex[1], vertex[0]);
    System.out.println();
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
