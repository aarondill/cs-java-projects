import java.util.Scanner;

public class Tyler {
  private static boolean tyler(int[] mult, int num) {
    whileLoop: while (true) {
      if (num == 0 || num == 1) return true;
      for (int x : mult) {
        if (x == 1 || x == 0) continue;
        if (num % x == 0) {
          num /= x;
          continue whileLoop;
        }
      }
      return false;
    }
  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Tyler.class.getResourceAsStream("./tyler.dat"))) {
      int n = dataScanner.nextInt();
      int m = dataScanner.nextInt();
      int[] mult = new int[n];
      for (int i = 0; i < n; i++)
        mult[i] = dataScanner.nextInt();
      for (int i = 0; i < m; i++) {
        int num = dataScanner.nextInt();
        System.out.println("Target " + num + ": " + (tyler(mult, num) ? "YES" : "NO"));
      }

    }

  }
}
