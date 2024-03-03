import java.util.Scanner;

public class Checkers {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Checkers.class.getResourceAsStream("./checkers.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        // Do Some Stuff
      }
    }

  }
}
