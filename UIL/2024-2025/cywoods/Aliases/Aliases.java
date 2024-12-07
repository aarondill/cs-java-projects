import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Aliases {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "aliases.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    String name = scan.nextLine();
    System.out.println(name.replaceAll("[0-9]", ""));
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
