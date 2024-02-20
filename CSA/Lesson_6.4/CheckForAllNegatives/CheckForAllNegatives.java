import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Primary java class: CheckForAllNegatives
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
public class CheckForAllNegatives {
  private static boolean allNegs(double[] nums) {
    // return java.util.Arrays.stream(nums).noneMatch(n -> n >= 0);
    for (double n : nums)
      if (n >= 0) return false;
    return true;

  }

  private static void printArray(double[] nums) {
    System.out.println(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
  }

  public static void main(String... args) {
    double[] dubs = {-2.5, 9.3, -6.7, -8.4, -9.2, 3.6, 1.2};
    printArray(dubs);
    System.out.println(allNegs(dubs));
    // dubs = new double[] {-2.5, -9.3, -6.7, -8.4, -9.2, -3.6, -1.2};
    // printArray(dubs);
    // System.out.println(allNegs(dubs));
  }
}
