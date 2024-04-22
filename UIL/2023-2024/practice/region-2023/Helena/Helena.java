import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Helena {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "helena.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    int wordSize = scan.nextInt(), lineCount = scan.nextInt();
    scan.nextLine();
    for (int i = 0; i < lineCount; i++) {
      System.out.print("'");
      String line = scan.nextLine();
      while (line.length() >= wordSize * 2) {
        String sub = line.substring(0, wordSize * 2);
        line = line.substring(wordSize * 2); // remove current
        sub = new StringBuilder(sub).reverse().toString();
        System.out.print(sub);
      }
      if (line.length() > 0) {
        System.out.print(new StringBuilder(line).reverse().toString());
      }
      System.out.println("'");
    }
    System.out.println("=========================");
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
