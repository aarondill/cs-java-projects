import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Primary java class: Sorted
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/23/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program that will determine if a list of whole
 * numbers entered by the user is in sorted order or not. Allow the user to
 * enter exactly eight numbers at the keyboard. Store the values in an
 * ArrayList. You must include a method named isSorted that has an ArrayList as
 * a formal parameter and returns true if the list is already sorted in
 * ascending order and false otherwise. (Hint: Modify the selection sort method
 * from this lesson so that it determines if any swaps are necessary.) Here are
 * two sample runs:
 * 
 * <pre>
 * Enter 8 whole numbers: 10 14 15 19 28 31 32 48
 * Sorted
 * Enter 8 whole numbers: 25 28 34 15 98 74 12 43
 * Not Sorted
 * </pre>
 */
public class Sorted {
  static final int N = 8;

  public static void main(String... args) {
    System.out.printf("Enter %d whole numbers: ", N);
    List<Integer> numbers = new ArrayList<Integer>();
    try (Scanner scan = new Scanner(System.in)) {
      IntStream.range(0, N).map(x -> scan.nextInt()).forEach(numbers::add);
    }
    System.out.println(isSorted(numbers) ? "Sorted" : "Not Sorted");
  }

  private static <T extends Comparable<T>> boolean isSorted(List<T> l) {
    for (int i = 0; i < l.size() - 1; i++) {
      T c = l.get(i);
      T next = l.get(i + 1);
      if (c.compareTo(next) > 0) return false;
    }
    return true;
  }
}
