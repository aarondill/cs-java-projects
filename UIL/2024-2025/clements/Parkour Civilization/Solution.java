import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

  private static void each(Scanner scan) {
    // Parse the input:
    /* int n = */ scan.nextInt();
    int k = scan.nextInt();
    scan.nextLine();
    List<Integer> nums = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    List<Integer> distances = new ArrayList<>(nums.size() * (int) Math.log(nums.size()));
    for (int i = 0; i < nums.size(); i++)
      for (int j = i; j < nums.size(); j++) {
        if (i == j) continue;
        distances.add(Math.abs(nums.get(i) - nums.get(j)));
      }
    distances.sort(null);
    System.out.println(distances.get(k - 1));
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      each(scan);
    }
  }
}
