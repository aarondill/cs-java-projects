import java.util.Scanner;

public class Tomek {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Tomek.class.getResourceAsStream("./tomek.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        // Do Some Stuff
      }
    }

  }
}
