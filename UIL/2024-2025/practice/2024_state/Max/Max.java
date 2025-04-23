import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Max {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "max.dat";

  final List<Game> games;

  // The constructor is called on each case
  private Max(Scanner scan) {
    int numGames = scan.nextInt();
    int gameTime = scan.nextInt(); // Total time allowed for games
    scan.nextLine();
    int[] gameTimes = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    double[] enjoyment = Arrays.stream(scan.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
    games = IntStream.range(0, numGames).mapToObj(i -> new Game(gameTimes[i], enjoyment[i])).toList();
    double maxEnjoyment = maxPermutation(gameTime);
    if (maxEnjoyment == 0) System.out.println("Should have picked better games...");
    else System.out.printf("%.2f\n", maxEnjoyment);
  }

  final Map<Integer, Double> enjoymentCache = new HashMap<>(); // A cache of timeRemaining -> maxEnjoyment

  public double maxPermutation(int timeRemaining) {
    if (enjoymentCache.containsKey(timeRemaining)) return enjoymentCache.get(timeRemaining);
    double maxEnjoyment = _maxPermutation(timeRemaining);
    enjoymentCache.put(timeRemaining, maxEnjoyment);
    return maxEnjoyment;
  }

  private double _maxPermutation(int timeRemaining) {
    double maxEnjoyment = 0;
    for (int i = 0; i < games.size(); i++) {
      Game game = games.get(i);
      if (game.time() > timeRemaining) continue; // we can't play this game!
      double enjoyment = game.enjoyment() + maxPermutation(timeRemaining - game.time());
      maxEnjoyment = Math.max(maxEnjoyment, enjoyment);
    }
    return maxEnjoyment;
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        new Max(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}

record Game(int time, double enjoyment) {}
