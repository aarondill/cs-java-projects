import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Solution {
  private static BigInteger factorial(long n) {
    BigInteger res = BigInteger.ONE;
    while (n > 1)
      res = res.multiply(BigInteger.valueOf(n--));
    return res;
  }

  private static BigInteger combos(int height, List<Integer> moves, int start, int movesUsed, List<Integer> combo) {
    if (height < 0) return BigInteger.ZERO; // We've gone too far
    // We've found a combo
    // NOTE: due to the start index, combo only includes unique combinations (ie, order matters)
    if (height == 0) {
      // Formula for unique permutations is n! / (n1! * n2! * ... * nk!) where nk is the number of repeated elements
      BigInteger permutations = factorial(movesUsed);
      Map<Integer, Long> nums =
          combo.stream().collect(Collectors.groupingBy(UnaryOperator.identity(), Collectors.counting()));
      for (var entry : nums.entrySet()) {
        long count = entry.getValue();
        if (count <= 1) continue;
        // Big integers are needed here because factorials can get too big (ie, 48!)
        permutations = permutations.divide(factorial(count));
      }

      // This is for the special move, which could be used on any move *OR* not used.
      return permutations.multiply(BigInteger.valueOf(1 + movesUsed));
    }

    BigInteger combos = BigInteger.ZERO;
    // The start variable means the order matters, but it also saves an enourmous amount of time.
    // Without it, the program times out.
    for (int i = start; i < moves.size(); i++) {
      combo.add(moves.get(i));
      combos = combos.add(combos(height - moves.get(i), moves, i, movesUsed + 1, combo));
      combo.remove(combo.size() - 1);
    }
    return combos;
  }

  // Returns the number of combos of moves (order matters, repeated moves are allowed) that can be made to equal the mountain height
  public static BigInteger combos(int height, List<Integer> moves) {
    return combos(height, moves, 0, 0, new ArrayList<>());
  }

  private static void each(Scanner scan) {
    int mountainHeight = scan.nextInt();
    /* int moveCount = */ scan.nextInt();
    scan.nextLine();
    List<Integer> moves = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    System.out.println(combos(mountainHeight, moves));
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++)
        each(scan);
    }
  }
}
