import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Colossus {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "colossus.dat";

  private static final BigInteger tenK = BigInteger.valueOf(10_000);

  private static void each(Scanner scan) {
    BigInteger n = scan.nextBigInteger();
    if (n.compareTo(tenK) > 0) System.out.println("Lunk Alarm!!");
    else System.out.println("Hulk here we come.");
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
