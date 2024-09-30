import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Catherine {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "catherine.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    String target = scan.next();
    String guess = scan.next();
    // Handle output:
    String answer = "";
    for (int i = 0; i < target.length(); i++) {
      char tc = target.charAt(i);
      char gc = guess.charAt(i);
      if (tc == gc) answer += Character.toUpperCase(tc);
      else if (target.contains(String.valueOf(Character.toLowerCase(gc)))) answer += Character.toLowerCase(gc);
      else answer += '*';
    }
    System.out.println(answer);
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
