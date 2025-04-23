import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dilbert {
  private static int caseNum = 1;
  private static final String INPUT_FILE = "dilbert.dat";

  /// The constructor is called on each case
  /// Each test case will produce 1 line of output containing the decimal
  /// equivalent of the reversed binary form followed by a single space and the
  /// reversed full binary form without leading 0s
  private Dilbert(Scanner scan) {
    long num = scan.nextLong();
    long dec = Long.toBinaryString(num).transform(this::reverse).transform(s -> Long.parseLong(s, 2));
    System.out.printf("Test Case: %d: %s %s\n", caseNum, dec, Long.toBinaryString(dec));
  }
  private String reverse(String s) {
    return new StringBuilder(s).reverse().toString();
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      while (scan.hasNextLong()) {
        new Dilbert(scan);
        caseNum++;
      }
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
