import java.util.Scanner;

public class Sofia {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Sofia.class.getResourceAsStream("./sofia.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        // Do Some Stuff
      }
    }

  }
}
