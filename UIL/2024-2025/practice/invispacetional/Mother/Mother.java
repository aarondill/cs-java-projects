import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mother {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "mother.dat";

  private static void each(Scanner scan) {
    int cycles = Integer.parseInt(scan.nextLine(), 10);
    long[] masters = new long[] {0, 0, 0, 0, 0};
    long sentinels = 0;

    for (int i = 0; i < cycles; i++) {
      masters[0] = masters[2] + 1; // reproducers + mother creates
      // Each mold ages by one (except the oldest)
      for (int j = masters.length - 1; j >= 1; j--) {
        masters[j] += masters[j - 1];
        masters[j - 1] = 0;
      }
      // Oldest molds create sentinels
      sentinels += masters[masters.length - 1];
    }
    System.out.println(sentinels);
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
