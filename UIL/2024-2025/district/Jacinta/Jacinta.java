import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Jacinta {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "jacinta.dat";

  private static void each(Scanner scan) {
    List<Long> nums = new ArrayList<>(
        Arrays.stream(scan.nextLine().split(" ")).filter(Predicate.not(String::isEmpty)).map(Long::parseLong).toList());
    nums.sort(null);
    nums = nums.reversed();
    long sumOne = 0, sumTwo = 0;
    if (nums.size() > 1) {
      sumOne = nums.removeFirst();
      sumTwo = nums.removeFirst();
      while (!nums.isEmpty()) {
        if (sumOne <= sumTwo) sumOne += nums.removeFirst();
        else sumTwo += nums.removeFirst();
      }
    }
    if (nums.size() == 1) sumOne = nums.removeFirst();
    if (sumOne == sumTwo) System.out.println("Job secured.");
    else System.out.println("Indeed here I come.");

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
