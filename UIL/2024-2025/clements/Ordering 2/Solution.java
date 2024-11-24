import java.util.Arrays;
import java.util.Scanner;

public class Solution {

  private static void swap(Object[] x, int a, int b) {
    Object t = x[a];
    x[a] = x[b];
    x[b] = t;
  }

  private static void each(Scanner scan) {
    String[] data = scan.nextLine().split(" ");
    int ops = 0;
    // selection sort the array, counting the number of swaps
    for (int i = 0; i < data.length; i++) {
      int min = i;
      for (int j = i + 1; j < data.length; j++) {
        if (data[min].compareTo(data[j]) > 0) {
          min = j;
        }
      }
      if (min != i) {
        swap(data, i, min);
        ops++;
      }
    }

    String[] sorted = Arrays.copyOf(data, data.length);
    Arrays.sort(data);
    if (!Arrays.equals(sorted, data)) {
      throw new RuntimeException("unsorted: " + Arrays.toString(sorted));
    }
    System.out.println(ops);
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++)
        each(scan);
    }
  }
}
