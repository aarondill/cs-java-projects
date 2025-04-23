import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Bethany {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "bethany.dat";

  // The constructor is called on each case
  private Bethany(Scanner scan) {
    int numOutputs = scan.nextInt();
    int numFactorsNeed = scan.nextInt();
    scan.nextLine();
    System.out.println(Stream.iterate(1, i -> i + 1) //
        .filter(i -> numFactors(i) == numFactorsNeed) //
        .limit(numOutputs) //
        .map(Object::toString) //
        .collect(Collectors.joining(" ")));
  }

  static Map<Integer, Long> numFactors = new HashMap<>(Map.of(1, 1l));

  static long numFactors(int i) {
    return numFactors.computeIfAbsent(i, _i -> {
      // Include both 1 and i in the factors
      return IntStream.rangeClosed(1, i).filter(j -> i % j == 0).count();
    });
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        new Bethany(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
