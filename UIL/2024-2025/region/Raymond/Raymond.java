import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Raymond {
  @SuppressWarnings("unused")
  private static long caseNum = 1;
  private static final String INPUT_FILE = "raymond.dat";

  // The constructor is called on each case
  private Raymond(Scanner scan) {
    long numInts = scan.nextInt();
    BigInteger curr = scan.nextBigInteger();
    for (int i = 0; i < numInts - 1; i++) {
      BigInteger compare = scan.nextBigInteger();
      long gcf = 1;

      BigInteger t = curr, t2 = compare;
      for (int ij = 0; ij < primes.size(); ij++) {
        var p = BigInteger.valueOf(primes.get(ij));
        if (t.mod(p).equals(BigInteger.ZERO) && t2.mod(p).equals(BigInteger.ZERO)) {
          t = t.divide(p);
          t2 = t2.divide(p);
          gcf *= primes.get(ij);
          ij--;
        }
      }

      curr = curr.divide(BigInteger.valueOf(gcf));
      curr = curr.multiply(compare);
    }
    if (curr.equals(BigInteger.ONE)) System.out.println("LCM NUMBER 1!");
    else System.out.println("Lowest Common Multiple is " + curr);

  }

  static List<Long> primes = new ArrayList<>();
  static {
    primes.add(2l);
    primes.add(3l);

    for (long i = 5; i < 1000; i += 2) {
      boolean isP = true;
      for (long p : primes) {
        if (i % p == 0) {
          isP = false;
          break;
        }
      }
      if (isP) primes.add(i);
    }
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      long dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (long i = 0; i < dataCount; i++, caseNum++)
        new Raymond(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
