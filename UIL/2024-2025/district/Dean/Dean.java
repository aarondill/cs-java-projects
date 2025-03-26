import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dean {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "dean.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    String s = scan.nextLine();
    int num = 0;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j <= s.length() - i; j++) {
        String sub = s.substring(j, j + i);
        if (new StringBuilder(sub).reverse().toString().equals(sub)) {
          num++;
        }
      }
    }
    System.out.println(num);
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
