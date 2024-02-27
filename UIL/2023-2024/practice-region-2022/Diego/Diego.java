import java.util.Scanner;

public class Diego {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Diego.class.getResourceAsStream("./diego.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        // Do Some Stuff
      }
    }

  }
}
