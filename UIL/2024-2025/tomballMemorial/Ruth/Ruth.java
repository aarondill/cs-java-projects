import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ruth {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "ruth.dat";

  private static void each(Scanner scan) {
    List<Integer> nums =
        new ArrayList<>(Arrays.asList(scan.nextLine().split(" ")).stream().map(Integer::parseInt).toList());
    int initialSum = nums.stream().mapToInt(x -> x).sum();

    int startVal = nums.getFirst(), startI = 0;
    int endI = -1, endVal = -1;

    for (int i = 1; i < nums.size(); i++) {
      if (nums.get(i) >= startVal) {
        endI = i;
        endVal = nums.get(i);
        Collections.fill(nums.subList(startI, endI), startVal);
        nums.set(endI, endVal);
        startVal = endVal;
        startI = endI;
      }
    }

    startI = nums.size() - 1;
    startVal = nums.getLast();

    for (int i = nums.size() - 1; i >= 0; i--) {
      if (nums.get(i) >= startVal) {
        endI = i;
        endVal = nums.get(i);
        Collections.fill(nums.subList(endI, startI), startVal);
        nums.set(endI, endVal);
        startVal = endVal;
        startI = endI;
      }
    }
    int sum = nums.stream().mapToInt(x -> x).sum();
    System.out.println(sum - initialSum);

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
