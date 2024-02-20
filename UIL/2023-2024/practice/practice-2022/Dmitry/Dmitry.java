import java.util.Arrays;
import java.util.Scanner;

/**
 * Primary java class: Dmitry
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    01/29/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Dmitry {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Dmitry.class.getResourceAsStream("./dmitry.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        String[] nums = dataScanner.nextLine().split("\\s+");
        int[] numsArray = new int[nums.length];
        for (int j = 0; j < nums.length; j++)
          numsArray[j] = Integer.parseInt(nums[j]);
        Arrays.sort(numsArray);
        for (int n : numsArray) {
          System.out.println("X".repeat(n));
        }

      }
    }
  }
}
