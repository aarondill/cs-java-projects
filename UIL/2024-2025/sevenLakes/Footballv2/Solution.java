import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
  private static void each(Scanner scan) {
    scan.nextLine(); // Minutes in game
    List<Integer> pointsWorth =
        Arrays.asList(scan.nextLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
    int home = 0, away = 0;
    for (int i = 0; i < pointsWorth.size(); i++) {
      if (i % 2 == 0) home += pointsWorth.get(i);
      else away += pointsWorth.get(i);
    }
    System.out.println(Math.abs(home - away));
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++)
        each(scan);
    }
  }
}
