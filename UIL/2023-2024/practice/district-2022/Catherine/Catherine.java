import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Catherine {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "catherine.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    char[] target = scan.next().toCharArray();
    char[] user = scan.next().toCharArray();
    scan.nextLine();
    // Handle output:
    char[] result = new char[target.length];
    outer: for (int i = 0; i < user.length; i++) {
      if (target[i] == user[i]) {
        result[i] = Character.toUpperCase(user[i]);
        continue;
      }
      for (char c : target) {
        if (c == user[i]) {
          result[i] = user[i];
          continue outer;
        }
      }
      result[i] = '*';
    }
    System.out.println(result);
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
