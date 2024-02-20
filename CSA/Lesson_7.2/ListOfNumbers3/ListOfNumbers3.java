import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Primary java class: ListOfNumbers3
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/13/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program that will prompt the user for three decimal
 * values. Add each of those decimal numbers to an ArrayList. AFTER the user has
 * enter the numbers into the list, rearrange the numbers in to numerical order
 * and print the ArrayList. You are required to use a static method to place the
 * values in order within the ArrayList. Pass the unordered list as a parameter
 * to the method and have the method return an ArrayList that has been arranged
 * in numerical order. Here is a sample run: ``
 *
 */
public class ListOfNumbers3 {
  // sort by selection sort
  private static <T extends Comparable<T>> void sort(List<T> list) {
    IntStream.range(0, list.size() - 1).forEach(i -> IntStream.range(i, list.size()).boxed()
        .min((a, b) -> list.get(a).compareTo(list.get(b))).ifPresent(min -> Collections.swap(list, i, min)));
  }

  public static void main(String... args) {
    ArrayList<Double> list = new ArrayList<>();
    try (Scanner input = new Scanner(System.in)) {
      IntStream.range(0, 3).boxed().map(i -> {
        System.out.print("Number? ");
        return input.nextDouble();
      }).forEach(list::add);
    }
    sort(list);
    System.out.println(list);

    // We've done it already. double check it. Remove this in production
    if (!list.stream().sorted().toList().equals(list)) throw new RuntimeException("Sorting failed");
  }
}
