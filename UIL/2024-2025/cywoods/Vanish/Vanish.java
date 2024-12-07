import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Vanish {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "vanish.dat";

  private static void each(Scanner scan) {
    int[] a = new int[scan.nextInt()];
    int[] b = new int[a.length];

    int moves = scan.nextInt();
    scan.nextLine();

    for (int i = 0; i < a.length; i++)
      a[i] = scan.nextInt();
    scan.nextLine();
    for (int i = 0; i < b.length; i++)
      b[i] = scan.nextInt();
    scan.nextLine();

    long sum = 0;
    for (int j = 0; j < moves; j++) {
      int maxA = -1;
      int maxAVal = -1;
      for (int i = 0; i < a.length; i++)
        if (a[i] > maxAVal) {
          maxA = i;
          maxAVal = a[i];
        }
      sum += maxAVal;
      a[maxA] = Math.max(0, a[maxA] - b[maxA]);
      if (maxAVal == 0) break;
    }
    System.out.println(sum);

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
