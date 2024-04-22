import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Javier {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "javier.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    int b1 = scan.nextInt(), b2 = scan.nextInt();
    String ch = scan.next().substring(0, 1);
    char dir = scan.next().charAt(0); // 'L' or 'R'
    scan.nextLine();
    // Handle output:
    for (int i = b1; (b2 > b1 ? (i <= b2) : (i >= b2)); i += (b2 > b1 ? 1 : -1)) {
      String p = ch.repeat(i);
      if (dir == 'L') {
        System.out.println(p);
      } else {
        System.out.println(" ".repeat(Math.max(b2, b1) - i) + p);
      }

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
