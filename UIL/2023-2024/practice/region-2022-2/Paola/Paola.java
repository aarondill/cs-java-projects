import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Paola {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "paola.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    char c = scan.next().charAt(0);
    int row = scan.nextInt();
    scan.nextLine();
    // Handle output:
    for (int i = 0; i < row; i++) {
      System.out.print(" ".repeat(row - i - 1));
      for (int j = 0; j < i + 1; j++) {
        System.out.print(c++);
        if (c > 'Z') c = 'A';
      }
      System.out.println();
    }
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
