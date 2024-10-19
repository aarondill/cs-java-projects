import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  private static void each(Scanner scan) {
    // Parse the input:
    List<String> input = new ArrayList<>(Arrays.asList(scan.nextLine().split("")));
    List<String> result = new ArrayList<>();
    for (String c : input) {
      if (result.contains(c)) result.remove(c);
      else result.add(c);
    }

    // Handle output:
    System.out.println(String.join("", result));
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++)
        each(scan);
    }
  }
}
