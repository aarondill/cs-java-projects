import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
  @SuppressWarnings("unused")
  private static int caseNum = 1;

  private static void each(Scanner scan) {
    // Parse the input:
    int friendCount = scan.nextInt();
    int limos = scan.nextInt();
    int capacity = scan.nextInt();
    scan.nextLine();
    int[] friendArrivals = Arrays.stream(scan.nextLine().split()).mapToInt(Integer::parseInt).toArray();
    // Handle output:
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(System.in)) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
