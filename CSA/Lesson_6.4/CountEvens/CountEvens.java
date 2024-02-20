import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Primary java class: CountEvens
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/01/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class CountEvens {
  public static void main(String... args) {
    int[] nums = {5, 23, 7, 14, 39, 46, 52, 75, 83, 76, 44, 90, 6, 2, 65, 5};
    printArray(nums);
    System.out.println("Number of even elements: " + numEvens(nums));
  }

  public static int numEvens(int[] nums) {
    // return (int) Arrays.stream(nums).filter(num -> num % 2 == 0).count();
    int count = 0;
    for (int num : nums)
      if (num % 2 == 0) count++;
    return count;

  }

  private static void printArray(int[] nums) {
    System.out.println(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
  }
}
