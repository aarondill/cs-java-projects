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
    int maxOffense = offense.stream().max(Integer::compareTo).get();
    int maxDefense = defense.stream().max(Integer::compareTo).get();

    if (maxOffense > maxDefense) System.out.println("Offense will win");
    else if (maxOffense < maxDefense) System.out.println("Defense will win");
    else System.out.println("There is no winner");
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++)
        each(scan);
    }
  }
}
