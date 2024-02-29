import java.util.ArrayList;

/**
 * Primary java class: Sort
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/29/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Sort {
  public static void insertion_sort(ArrayList<Integer> list) {
    for (int next = 1; next < list.size(); next++) {
      int current = list.get(next);
      int i = next - 1;
      while (i >= 0 && list.get(i) > current) { // this works
        list.set(i + 1, list.get(i)); // error 1
        i--;
      }
      list.set(i + 1, current); // error 2
    }
  }

  public static void main(String... args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    int count = args.length > 0 ? Integer.parseInt(args[0]) : 100;
    for (int i = 0; i < count; i++)
      list.add((int) (Math.random() * 100));
    System.out.println(list);
    var sorted = list.stream().sorted().toList();
    insertion_sort(list);
    System.out.println(list);
    if (!sorted.equals(list)) throw new RuntimeException("Sorting failed!");
  }
}
