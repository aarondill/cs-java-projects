import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Diane {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "diane.dat";

  private static int[] parse(String a) {
    int[] ai;
    if (a.contains("/")) {
      if (a.contains(" ")) {
        int whole = Integer.parseInt(a.split(" ")[0]);
        a = a.split(" ")[1];
        int num = Integer.parseInt(a.split("/")[0]), denom = Integer.parseInt(a.split("/")[1]);
        if (whole < 0) num = -num;
        num += whole * denom;
        ai = new int[] {num, denom};
      } else ai = new int[] {Integer.parseInt(a.split("/")[0]), Integer.parseInt(a.split("/")[1])};
    } else ai = new int[] {Integer.parseInt(a, 10), 1};
    return ai;
  }

  private static int[] simplify(int num, int denom) {
    for (int i = Math.min(num, denom); i >= 2; i--) {
      if (num % i == 0 && denom % i == 0) return new int[] {num / i, denom / i};
    }
    return new int[] {num, denom};
  }

  private static void each(Scanner scan) {
    // Parse the input:
    String[] parts = scan.nextLine().split(" and ");
    int[] ai = parse(parts[0]), bi = parse(parts[1]);
    int a = ai[0], b = ai[1], c = bi[0], d = bi[1];
    int newNum = a * d + b * c;
    int newDenom = b * d;
    if (newDenom == 1) System.out.println(newNum);
    else if (Math.abs(newNum) < newDenom) {
      int[] f = simplify(newNum, newDenom);
      newNum = f[0];
      newDenom = f[1];
      System.out.printf("%d/%d\n", newNum, newDenom);
    } else {
      System.out.print(newNum / newDenom + " ");
      newNum -= newNum / newDenom * newDenom;
      int[] f = simplify(newNum, newDenom);
      newNum = f[0];
      newDenom = f[1];
      System.out.printf("%d/%d\n", Math.abs(newNum), newDenom);;
    }

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
