import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Slow {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "slow.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    List<Integer> nums = Arrays.stream(scan.nextLine().split("\\++")).map(Integer::parseInt).toList();
    // Handle output:
    int sum = nums.stream().mapToInt(Integer::intValue).sum();
    System.out.printf("%s makes %d!\n", "1" + "+1".repeat(sum - 1), sum);
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
