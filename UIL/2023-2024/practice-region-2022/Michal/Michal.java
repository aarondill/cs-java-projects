import java.util.Scanner;

public class Michal {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Michal.class.getResourceAsStream("./michal.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        // Do Some Stuff
      }
    }

  }
}
