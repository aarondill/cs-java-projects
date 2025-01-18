import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Danielle {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "danielle.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    String[] line = scan.nextLine().split(",");
    int num1 = Integer.parseInt(line[0]), num2 = Integer.parseInt(line[1]), num3 = Integer.parseInt(line[2]),
        num4 = Integer.parseInt(line[3]);
    num1 -= 1;
    num2 -= 2;
    num3 -= 3;
    num4 -= 4;
    System.out.println(num1 * 1 + num2 * 9 + num3 * 72 + num4 * 504 + 1);
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
