import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Chalam {
  private static final String INPUT_FILE = "chalam.dat";

  private static List<Integer> factor(int num, int primeStart) {
    if (num == 1) return List.of();
    List<Integer> factors = new ArrayList<>((int) Math.log10(num) + 1);
    // loop known primes, if factor, recurse
    for (int i = primeStart; i < primes.size(); i++) {
      int p = primes.get(i);
      if (num % p == 0) {
        factors.add(p);
        factors.addAll(factor(num / p, i));
        return factors;
      }
    }
    var sqrt = (int) Math.sqrt(num);
    for (int i = START; i <= sqrt; i++) {
      if (num % i == 0) {
        factors.addAll(factor(i, 0));
        factors.addAll(factor(num / i, primes.size() - 1));
        return factors;
      }
    }
    // if prime, add to factors
    if (factors.isEmpty()) {
      primes.add(num);
      factors.add(num);
    }
    return factors;
  }

  private static void each(Scanner scan) {
    int num = scan.nextInt();
    if (scan.hasNextLine()) scan.nextLine();
    List<Integer> factors = factor(num, 0);
    Map<Integer, Integer> factorsOccurrances = factors.stream().collect(TreeMap<Integer, Integer>::new,
        (m, i) -> m.put(i, m.getOrDefault(i, 0) + 1), Map::putAll);

    for (var e : factorsOccurrances.entrySet()) {
      System.out.print(e.getKey());
      if (e.getValue() > 1) System.out.print("^" + e.getValue());
      System.out.print(' ');
    }
    System.out.println();
  }

  static List<Integer> primes = new ArrayList<>(1_000_000);
  static {
    primes.add(2);
    primes.add(3);
    primes.add(5);
    primes.add(7);
    primes.add(11);
    primes.add(13);
    primes.add(17);
    primes.add(19);
    primes.add(23);
    primes.add(29);
    primes.add(31);
    START = primes.getLast();
  }
  static final int START;

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++)
        each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
