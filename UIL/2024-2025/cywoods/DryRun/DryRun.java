import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DryRun {
  private static final String INPUT_FILE = "dryrun.dat";

  private static void each(Scanner scan) {
    String s = scan.nextLine().trim();
    System.out.printf("I like %s.\n", s);
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++)
        each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
