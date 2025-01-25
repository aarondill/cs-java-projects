import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Martyn {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "martyn.dat";

  static final List<Character> SYMBOLS =
      "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/".chars().mapToObj(c -> (char) c).toList();

  // NOTE: only has to handle positive numbers
  private static String toBase(int n, int b) {
    List<Character> digits = SYMBOLS.subList(0, b);
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
      sb.append(digits.get(n % b));
      n /= b;
    }
    return sb.reverse().toString();
  }

  private static void each(Scanner scan) {
    // Parse the input:
    int n = Integer.parseInt(scan.nextLine());
    String res = IntStream.rangeClosed(2, 64).filter(i -> {
      List<Character> chars = toBase(n, i).chars().mapToObj(c -> (char) c).toList();
      return chars.reversed().equals(chars);
    }).mapToObj(String::valueOf).collect(Collectors.joining(", ")).transform(s -> s.isEmpty() ? "None." : s);
    System.out.println(res);
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
