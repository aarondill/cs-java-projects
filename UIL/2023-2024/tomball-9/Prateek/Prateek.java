import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Prateek {
  private static void prateek(List<Integer> A, int depth, Map<Integer, List<Integer>> res) {
    List<Integer> forDepth = res.getOrDefault(depth, new ArrayList<>());
    res.put(depth, forDepth);
    int l = 0;
    int r = A.size() - 1;
    int m = Math.floorDiv(l + r, 2);
    if (l > r || m > A.size()) return;
    forDepth.add(A.get(m));
    if (m - 1 >= 0 && l < m - 1 + 1) prateek(A.subList(l, m - 1 + 1), depth + 1, res);
    if (m + 1 < A.size() && m + 1 < r + 1) prateek(A.subList(m + 1, r + 1), depth + 1, res);

  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Prateek.class.getResourceAsStream("./prateek.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        List<Integer> nums = new ArrayList<Integer>();
        Arrays.stream(dataScanner.nextLine().split(" ")).map(Integer::parseInt).sorted().forEach(nums::add);
        Map<Integer, List<Integer>> res = new HashMap<>();
        prateek(nums, 1, res);
        System.out.println("List: " + nums.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        for (var entry : res.entrySet()) {
          var s = entry.getValue();
          s.sort(null);
          System.out.println(
              entry.getKey() + "-iterations: " + s.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
        System.out.println();
      }
    }

  }
}
