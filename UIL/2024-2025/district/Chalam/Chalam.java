import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Chalam {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "chalam.dat";

  private static void each(Scanner scan) {
    int num = scan.nextInt();
    if (scan.hasNextLine()) scan.nextLine();
    Map<Integer, Integer> factors = new TreeMap<>();
    while (num > 1) {
      for (int i = 0; i < primes.size(); i++) {
        int p = primes.get(i);
        if (num % p == 0) {
          factors.put(p, 1 + factors.getOrDefault(p, 0));
          num /= p;
          i--;
        }
      }
    }

    for (var e : factors.entrySet()) {
      System.out.print(e.getKey());
      if (e.getValue() > 1) System.out.print("^" + e.getValue());
      System.out.print(' ');
    }
    System.out.println();
  }

  static List<Integer> primes = new ArrayList<>(1_000_000);

  public static void main(String... args) throws FileNotFoundException {
    primes.add(2);
    for (int i = 3; i < Integer.MAX_VALUE; i += 2) {
      boolean isPrime = true;
      for (int a : primes) {
        if (a <= Math.sqrt(i)) {
          if (i % a == 0) {
            isPrime = false;
            break;
          }
        } else break;
      }
      if (isPrime) primes.add(i);
    }

    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
