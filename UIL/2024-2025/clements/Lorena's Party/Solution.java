import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
  @SuppressWarnings("unused")
  private static int caseNum = 1;

  private static void each(Scanner scan) {
    // Parse the input:
    /* int friendCount = */ scan.nextInt();
    int limos = scan.nextInt();
    int capacity = scan.nextInt();
    scan.nextLine();
    List<Integer> friendArrivals = (Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt)
        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll));
    friendArrivals.sort(Integer::compareTo);
    // Handle output:
    // totalTime / capacity / limos = the amount of time for each limo
    int maxWaitTime = 0;
    int limoIndex = 0;
    for (int i = 0; i < limos; i++) {
      var start = limoIndex;
      var end = start + Math.min(friendArrivals.size() / limos, capacity);
      end = Math.min(end, friendArrivals.size());
      limoIndex = end + 1;
      if (start >= friendArrivals.size()) throw new IllegalStateException("Empty limo. We've failed?");
      var limo = friendArrivals.subList(start, end);
      if (limo.isEmpty()) continue;
      int waitTime = limo.get(limo.size() - 1) - limo.get(0);
      maxWaitTime = Math.max(maxWaitTime, waitTime);
    }
    System.out.println(maxWaitTime);
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        each(scan);
    }
  }
}
