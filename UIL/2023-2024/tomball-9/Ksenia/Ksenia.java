import java.util.Scanner;

public class Ksenia {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Ksenia.class.getResourceAsStream("./ksenia.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        // Do Some Stuff
      }
    }

  }
}
