import java.util.Scanner;

public class Climb {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Climb.class.getResourceAsStream("./climb.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        int n = dataScanner.nextInt();
        for (int j = 1; j <= n; j++) {
          System.out.print(" ".repeat(n - j));
          System.out.print("C".repeat(j));
          System.out.println();
        }
        System.out.println();
      }
    }

  }
}
