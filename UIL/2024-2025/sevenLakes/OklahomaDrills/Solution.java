import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
  private static void each(Scanner scan) {
    // Parse the input:
    scan.nextLine(); // Ignore number of players
    List<Integer> offense =
        Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    List<Integer> defense =
        Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    // Handle output:
    while (offense.size() > 0 && defense.size() > 0) {
      int o = offense.remove(0);
      int d = defense.remove(0);
      if (o > d) {
        offense.add(o);
      } else if (o < d) {
        defense.add(d);
      }
    }

    if (defense.size() == 0 && offense.size() == 0) System.out.println("There is no winner");
    else if (defense.size() == 0) System.out.println("Offense will win");
    else if (offense.size() == 0) System.out.println("Defense will win");
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++)
        each(scan);
    }
  }
}
