import java.util.Scanner;

public class Duke {
  public static void main(String[] args) {
    try (Scanner dataScanner = new Scanner(Duke.class.getResourceAsStream("./duke.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        int lines = dataScanner.nextInt();
        int cols = dataScanner.nextInt();
        String c = dataScanner.next();
        for (int j = 0; j < lines; j++) {
          System.out.print(c.repeat(cols));
          System.out.println();
        }
      }
    }
  }
}
