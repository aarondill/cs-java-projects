import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Amy {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "amy.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    String c = scan.next();
    BigInteger i = scan.nextBigInteger();
    scan.nextLine();
    // Handle output:
    BigInteger res = (new BigInteger("36").pow(c.length())).divide(i);
    System.out.println(res);
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
