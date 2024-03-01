import java.util.Scanner;

public class Ricardo {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Ricardo.class.getResourceAsStream("./ricardo.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        String line = dataScanner.nextLine();
        System.out.printf("Case #%d: %.0f\n", i + 1, Math.pow(2, line.chars().filter(c -> c == '|').count()));
        // Do Some Stuff
      }
    }

  }
}
