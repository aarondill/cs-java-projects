import java.util.OptionalInt;
import java.util.Scanner;

/**
 * Primary java class: Ishika
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/02/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Ishika {
  // Return the sum of the two numbers that greater than or equal to the given target (closest to target!)
  private static OptionalInt twoNumsSum(int[] nums, int target) {
    if (nums.length == 0) return OptionalInt.empty();
    if (nums.length == 1) return nums[0] >= target ? OptionalInt.of(nums[0]) : OptionalInt.empty();

    Integer lowest = null;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] >= target) {
          if (lowest == null || nums[i] + nums[j] < lowest) lowest = nums[i] + nums[j];
        }
      }
    }
    return lowest != null ? OptionalInt.of(lowest) : OptionalInt.empty();
  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Ishika.class.getResourceAsStream("./ishika.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        int len = dataScanner.nextInt();
        int[] nums = new int[len];
        for (int j = 0; j < len; j++)
          nums[j] = dataScanner.nextInt();
        twoNumsSum(nums, 20).ifPresentOrElse(System.out::println, () -> System.out.println("NOT POSSIBLE"));
      }
    }

  }
}
