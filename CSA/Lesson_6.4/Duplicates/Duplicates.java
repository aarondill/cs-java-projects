import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Primary java class: Duplicates
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/01/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a method called hasDupes to determine if an array
 * contains any duplicates (same element contained more than once), returning
 * true if so, false if not. Use the program shell and output shown below as a
 * guide.
 * 
 * There may be more than one way to deal with this algorithm, and if yours
 * differs than another's, that's OK, as long as it works!
 * 
 * For the second run, change the last element of the test array from 5 to 11,
 * or any other non-duplicate value you can think of.
 *
 * 
 */
public class Duplicates {
  public static boolean hasDupes(int[] list) {
    Set<Integer> found = new HashSet<>();
    for (int n : list) {
      if (found.contains(n)) return true;
      found.add(n);
    }
    return false;

  }

  private static void printArray(int[] nums) {
    System.out.println(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
  }

  public static void main(String... args) {
    int[] nums = {5, 23, 7, 14, 39, 46, 52, 75, 83, 76, 44, 90, 6, 2, 65, 5};
    printArray(nums);
    System.out.println(hasDupes(nums));
  }
}
