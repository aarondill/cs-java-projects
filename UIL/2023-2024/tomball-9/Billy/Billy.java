import java.util.Scanner;

public class Billy {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Billy.class.getResourceAsStream("./billy.dat"))) {
      String winner = null;
      double max = 0;
      for (int i = 0; i < 16 / 2; i++) {
        String name = dataScanner.nextLine();
        double A = dataScanner.nextInt();
        double B = dataScanner.nextInt();
dataScanner.nextLine();
        double winPercent = A / (A + B);
        if (winPercent > max) {
          winner = name;
          max = winPercent;
        }
      }
      System.out.println(winner);
    }

  }
}
