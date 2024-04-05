import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Arya {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "arya.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    // N is the largest number in the set [1, N]
    // R is the target number [1, N]
    int N = scan.nextInt(), R = scan.nextInt();
    // Binary search! Output %d-%d-%d, low value current range, current guess, high value range
    // Ouput GOT IT!!! After found
    int low = 1, high = N;
    while (low <= high) {
      int guess = (low + high) / 2;
      System.out.printf("%d-%d-%d\n", low, guess, high);
      if (guess == R) {
        System.out.println("GOT IT!!!");
        return;
      } else if (guess > R) {
        high = guess - 1;
      } else {
        low = guess + 1;
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
