import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Veerasamy {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "veerasamy.dat";

  // The constructor is called on each case
  private Veerasamy(Scanner scan) {
    throw new UnsupportedOperationException("Not Attempted"); /* TODO: Delete this line */
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        new Veerasamy(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
