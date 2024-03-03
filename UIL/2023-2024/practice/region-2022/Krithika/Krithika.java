import java.util.Scanner;

public class Krithika {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Krithika.class.getResourceAsStream("./krithika.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        // Do Some Stuff
      }
    }

  }
}
