import java.util.Scanner;

/**
 * Primary java class: Andrew
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/03/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Andrew {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Andrew.class.getResourceAsStream("./andrew.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        int num = dataScanner.nextInt();
        for (int j = 1; j < 10 && j <= num; j++) {
          if (num % j != 0) continue;
          String s = switch (j) {
            case 1 -> "ONE";
            case 2 -> "TWO";
            case 3 -> "THREE";
            case 4 -> "FOUR";
            case 5 -> "FIVE";
            case 6 -> "SIX";
            case 7 -> "SEVEN";
            case 8 -> "EIGHT";
            case 9 -> "NINE";
            default -> throw new IllegalArgumentException();
          };
          System.out.print(s + " ");
        }
        System.out.println();
      }
    }
  }
}
