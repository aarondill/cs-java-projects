import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dante {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "dante.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    int a = scan.nextInt();
    int b = scan.nextInt();
    scan.nextLine();
    int start = -1;
    while (++start < primes.size() && primes.get(start) <= a);

    int total = 0;
    while ((start) < primes.size() && primes.get(start++) < b)
      total++;

    System.out.println(total);

  }

  static List<Integer> primes = new ArrayList<>();

  public static void main(String... args) throws FileNotFoundException {
    primes.add(2);
    primes.add(3);
    outer: for (int i = 5; i < 100_000; i += 2) {
      for (int j = 0; j < primes.size() && primes.get(j) <= Math.sqrt(i); j++) {
        int n = primes.get(j);
        if (i % n == 0) continue outer;
      }
      primes.add(i);
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
