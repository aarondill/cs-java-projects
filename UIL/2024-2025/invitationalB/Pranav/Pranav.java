import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Pranav {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "pranav.dat";

  static record Key(List<Integer> nums, int turn) {} // A map key

  Map<Key, int[]> cache = new HashMap<>();

  public int[] play(List<Integer> nums, int turn) {
    Key cacheKey = new Key(nums, turn);
    if (cache.containsKey(cacheKey)) return cache.get(cacheKey);
    int[] result = _play(nums, turn);
    cache.put(cacheKey, result);
    return result;
  }

  /**
   * Plays the game.
   *
   * @param nums the numbers to play with
   * @param turn either 0 or 1 (index of scores[i])
   * @return the max score possible given the numbers in the list
   */
  private int[] _play(List<Integer> nums, int turn) {
    if (nums.isEmpty()) return new int[] {0, 0};
    if (nums.size() == 1) {
      int[] result = new int[] {0, 0};
      result[turn] += nums.getFirst();
      return result;
    }
    // Pick left
    int[] leftScore = play(nums.subList(1, nums.size()), (turn + 1) % 2).clone();
    leftScore[turn] += nums.getFirst(); // Add the points from this round
    // Pick right
    int[] rightScore = play(nums.subList(0, nums.size() - 1), (turn + 1) % 2).clone();
    rightScore[turn] += nums.getLast(); // Add the points from this round

    // Compare scores - Optimize for max scores[turn]
    return leftScore[turn] > rightScore[turn] ? leftScore : rightScore;
  }

  private Pranav(Scanner scan) {
    // Parse the input:
    List<Integer> nums = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).toList();
    int[] scores = play(nums, 0);
    int p1 = scores[0], p2 = scores[1];
    if (p1 > p2) System.out.println("Winner " + p1);
    else if (p1 == p2) System.out.println("Tie " + p1);
    else System.out.println("Loser " + p2);
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        new Pranav(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
