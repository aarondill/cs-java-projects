import java.util.Scanner;

public class Jana {
  private static String repeat(String s, int num) {
    return s.repeat(Math.max(num, 0));
  }

  int depth = 0;

  private static void row(int i, int width, int depth) {
    if (width <= 0) return;
    if (i == 0) {
      System.out.println("#".repeat(width));
      row(i + 1, width, depth);
      return;
    } else if (i == width) {
      System.out.println("#".repeat(width));
    } else if (i == 1 || i == width - 1) {
      System.out.println("#" + " #".repeat(depth) + " ".repeat(width - 2 * (2 * depth)) + " #".repeat(depth));
    } else { // another box!
      if (width - 2 * (2 * depth) > 0) row(0, width, depth + 1);
      System.out.println("width = " + width + "depth = " + depth + " i = " + i);
    }
  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Jana.class.getResourceAsStream("./jana.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        int n = dataScanner.nextInt();
        // System.out.println("#".repeat(n));
        // System.out.println("#" + repeat(" ", n - 2) + "#");
        row(n, n - 4, 0);
        // System.out.println("#".repeat(n));
        // System.out.println("#" + repeat(" ", n - 2) + "#");

      }
    }

  }
}
