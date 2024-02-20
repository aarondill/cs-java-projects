import java.util.ArrayList;
import java.util.List;

/**
 * Primary java class: ListOfNumbers2
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/13/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program that will create an ArrayList of whole
 * numbers.
 * 
 * Add the following numbers to the list: 0, -5, 7, 12, and -1. Print the list.
 * Insert the number 10 as the 3rd value in the list. Replace -5 with 9. Print
 * the list. Delete 12 from the list. Print the list. Your program's output
 * should match the output shown here exactly:
 *
 */
public class ListOfNumbers2 {
  public static void main(String... args) {
    List<Integer> list = new ArrayList<Integer>();
    for (int n : new int[] {0, -5, 7, 12, -1})
      list.add(n);
    System.out.println(list);
    list.add(2, 10);
    list.set(1, 9);
    System.out.println(list);
    list.remove(4);
    System.out.println(list);
  }
}
