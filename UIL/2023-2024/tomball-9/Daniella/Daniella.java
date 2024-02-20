import java.util.Scanner;

public class Daniella {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Daniella.class.getResourceAsStream("./daniella.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        String word = dataScanner.next();
        int n = dataScanner.nextInt();
        for (int j = 0; j < word.length(); j += n) {
          int end = Math.min(j + n, word.length());
          System.out.print(word.substring(j, end));
          if (end != word.length()) System.out.print("-");
        }
        System.out.println();
      }
    }

  }
}
