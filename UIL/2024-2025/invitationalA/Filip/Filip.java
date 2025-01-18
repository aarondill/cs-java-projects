import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Filip {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "filip.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    int height = scan.nextInt();
    int width = scan.nextInt();
    char c = scan.next().charAt(0);
    boolean filled = scan.nextBoolean();
    scan.nextLine();
    // Handle output:
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        if (filled || x == 0 || x == width - 1 || y == 0 || y == height - 1) System.out.print(c);
        else System.out.print(' ');
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
