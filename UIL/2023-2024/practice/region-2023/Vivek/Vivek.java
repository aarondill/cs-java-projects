import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Vivek {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "vivek.dat";

  private static double dist(double x1, double y1, double z1, double x2, double y2, double z2) {
    return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) + Math.pow(z1 - z2, 2));
  }

  private static void each(Scanner scan) {
    // Parse the input:
    double x = scan.nextDouble(), y = scan.nextDouble(), z = scan.nextDouble();
    int g = scan.nextInt();
    scan.nextLine();
    int n = scan.nextInt();
    scan.nextLine();
    int counter = 0;
    for (int i = 0; i < n; i++) {
      scan.next(); // name
      if (!scan.nextBoolean()) {
        scan.nextLine();
        continue;
      }
      double dist = dist(x, y, z, scan.nextDouble(), scan.nextDouble(), scan.nextDouble());
      if (dist <= g) counter++;
    }
    if (counter > 0) {
      System.out.println("We made it Rick: " + counter);
    } else {
      System.out.println("SS Madame de Pompadour");
    }

    // Handle output:
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
