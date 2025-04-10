import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pranav {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "pranav.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    List<Integer> nums = new ArrayList<>(Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).toList());
    int p1 = 0, p2 = 0;
    while (!nums.isEmpty()) {
      if (nums.get(0) - nums.get(1) > nums.getLast() - nums.get(nums.size() - 2)) {
        p1 += nums.remove(0);
      } else p1 += nums.removeLast();

      if (nums.size() == 1) p2 += nums.removeLast();
      else {
        if (nums.get(0) - nums.get(1) > nums.getLast() - nums.get(nums.size() - 2)) {
          p2 += nums.remove(0);
        } else p2 += nums.removeLast();
      }
    }
    if (p1 > p2) System.out.println("Winner " + p1);
    else if (p1 == p2) System.out.println("Tie " + p1);
    else System.out.println("Loser " + p2);

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
