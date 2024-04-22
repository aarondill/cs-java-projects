import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cynthia {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "cynthia.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    List<Integer> nums = new ArrayList<>(Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).toList());
    // Handle output:
    nums.sort(null); // desc
    nums = nums.reversed();
    int height = nums.get(0);
    int sum = nums.stream().skip(1).reduce(0, (a, b) -> a + b);
    double area = height * sum / 2.0;

    System.out.printf("%,.1f0\n", area);

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
