import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lavanya {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "lavanya.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    int n = scan.nextInt();
    scan.nextLine();
    // Handle output:
    System.out.print(n + " = ");
    if (n == Integer.MAX_VALUE) {
      System.out.println(n);
      return;
    }

    int on = n;
    List<Integer> primes = new ArrayList<>();
    outer: for (int i = 2; i < (n); i++) {
      for (int j = 2; j <= Math.sqrt(i); j++)
        if (i % j == 0) continue outer;
      // i is prime!
      if (n % i != 0) continue;
      primes.add(i);
      n /= i;
      i--;
    }
    primes.sort(null);
    if (primes.size() == 0) primes.add(on);
    System.out.println(String.join(" * ", primes.stream().map(String::valueOf).toList()));
  }

  public static void main(String... args) throws FileNotFoundException {
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
