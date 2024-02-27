import java.util.Scanner;

public class Ricardo {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Ricardo.class.getResourceAsStream("./ricardo.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        // Do Some Stuff
      }
    }

  }
}
