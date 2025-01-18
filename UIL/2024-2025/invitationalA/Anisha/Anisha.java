import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Anisha {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "anisha.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    int current = scan.nextInt();
    scan.nextLine();
    // Handle output:
    if (current < 15) System.out.println("On my way to Dehydration Station.");
    else System.out.println("Way to go, H2O.");
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
