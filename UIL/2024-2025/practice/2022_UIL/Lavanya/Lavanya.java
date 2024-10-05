import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lavanya {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "lavanya.dat";

  private static List<Integer> primeFactors(int n) {
    List<Integer> pfs = new LinkedList<>(); // faster add
    int tmp = n;
    int sqrt = (int) Math.sqrt(n);
    for (int i = 2; i < sqrt; i++) {
      if (tmp % i != 0) continue;
      pfs.add(i);
      tmp /= i;
      i--;
    }
    if (tmp > 1) pfs.add(tmp);
    return pfs;
  }

  private static void each(Scanner scan) {
    // Parse the input:
    int n = Integer.parseInt(scan.nextLine());
    // Handle output:
    var pfs = primeFactors(n);
    System.out.println(n + " = " + pfs.stream().map(String::valueOf).collect(Collectors.joining(" * ")));
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
