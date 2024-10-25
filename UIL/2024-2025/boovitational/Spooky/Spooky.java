import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Spooky {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "spooky.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    while (scan.hasNextLong()) {
      long n = scan.nextLong();
      int count = 0;
      if (n % 10 == 4 || n % 10 == 9) count++;
      if (Long.toString(n, 16).toUpperCase().contains("F13")) count++;
      if (n % 17 == 0 || n % 39 == 0 || n % 43 == 0) count++;
      if (Long.toString(n).contains("666")) count++;

      System.out.print(n + " ");
      if (count == 0) System.out.println("Candy");
      else if (count == 1) System.out.println("BOO!");
      else System.out.println("AAAA!");
    }
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
