import java.util.Scanner;

public class Juana {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Juana.class.getResourceAsStream("./juana.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        // Do Some Stuff
      }
    }

  }
}
