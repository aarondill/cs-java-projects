import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Becker {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "becker.dat";

  private static void each(Scanner scan) {
    double a = scan.nextDouble(), r = scan.nextDouble(), n = scan.nextDouble(), t = scan.nextDouble();
    double p = Math.pow(1 + (r / 100) / n, n * t);
    long ans = (long) Math.ceil(a / p);
    System.out.println(ans);
    scan.nextLine();
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      while (scan.hasNextLine())
        each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
