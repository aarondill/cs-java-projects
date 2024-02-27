import java.util.Scanner;

public class Fai {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Fai.class.getResourceAsStream("./fai.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        // Do Some Stuff
      }
    }

  }
}
