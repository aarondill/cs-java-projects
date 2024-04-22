import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Neeraj {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "neeraj.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    String s = scan.nextLine();
    // Handle output:
    s = s.substring(1);
    double denom = Math.pow(10, s.length());
    double num = Double.parseDouble(s);
    for (int i = 2; i < denom; i++) {
      if (num % i == 0 && denom % i == 0) {
        num /= i;
        denom /= i;
        i--;
      }
    }
    System.out.printf(".%s is equal to %.0f/%.0f\n", s, num, denom);
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
