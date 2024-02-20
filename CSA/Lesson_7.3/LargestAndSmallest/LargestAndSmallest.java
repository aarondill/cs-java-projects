import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Stream;
import javax.print.DocFlavor.INPUT_STREAM;

/**
 * Primary java class: LargestAndSmallest
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/15/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program that will read a list of whole numbers from
 * a file named numbers.dat and store those values in an ArrayList. AFTER the
 * numbers have been placed into the list, traverse the ArrayList to print each
 * of the values in the list with one space between each number. Also create and
 * use methods to find and print the largest number in the list and the smallest
 * number in the list. Process the numbers by traversing the ArrayList using an
 * enhanced for loop. Do not do any of the processing as the numbers are read
 * from the file. Your output should appear similar to the sample output shown
 * on the right.
 * 
 */
public class LargestAndSmallest {
  // Evil method that does output to stdout. It's required by the assignment,
  // but typically you would avoid side effects and instead just return the
  // number. This would have the added benifit of allowing the caller to
  // determine output format, both when the list is empty and otherwise.
  // Additionally, since this would just become a wrapper around the Stream
  // API, it would be removed, since the max/min of the list can be found in a
  // single line idomatically by calling Stream.max(Integer::compareTo) and a
  // stream can be gotten with just List.stream(), so this method could be
  // entirely reduced to the expression `list.stream().max(Integer::compareTo).get()`.
  // Additionally, if the user needs the max *and* min of the list, using these
  // methods requires that the list is iterated twice. Instead they should
  // write their own loop, or use IntSummaryStatistics, which supplies max,
  // min, and count, and can be used inline with the data collection.
  private static void max(List<Integer> numbers) {
    if (numbers.size() == 0) {
      System.out.println("Largest number doesn't exist, since the list is empty");
      return;
    }
    int res = Integer.MIN_VALUE;
    for (int n : numbers)
      res = Math.max(res, n);
    System.out.println("Largest number is " + res);

  }

  // See above note about evil side effects
  private static void min(List<Integer> numbers) {
    if (numbers.size() == 0) {
      System.out.println("Smallest number doesn't exist, since the list is empty");
      return;
    }
    int res = Integer.MAX_VALUE;
    for (int n : numbers)
      res = Math.min(res, n);
    System.out.println("Smallest number is " + res);
  }

  public static void main(String... args) {
    List<Integer> numbers = new ArrayList<Integer>();
    try (Scanner scan = new Scanner(LargestAndSmallest.class.getResourceAsStream("./numbers.dat"))) {
      scan.tokens().map(Integer::parseInt).forEach(numbers::add);
    }
    for (int num : numbers)
      System.out.print(num + " ");
    System.out.println();
    max(numbers);
    min(numbers);
  }
}
