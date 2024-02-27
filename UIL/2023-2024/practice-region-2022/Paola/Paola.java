import java.util.Scanner;

public class Paola {
  public static void does(char ch, int n) {
    for (int i = 0; i < n; i++) {
      System.out.print(" ".repeat(n - i));
      for (int j = 0; j < i + 1; j++) {
        System.out.print(ch++);
        if (ch > 'Z') ch = 'A';
      }
      System.out.println();
    }
  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Paola.class.getResourceAsStream("./paola.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        char ch = dataScanner.next().charAt(0);
        int n = dataScanner.nextInt();
        does(ch, n);
      }
    }

  }
}
