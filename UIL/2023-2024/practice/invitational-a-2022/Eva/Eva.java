import java.util.Scanner;

/**
 * Primary java class: Eva
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/02/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Eva {
  static int caseNum = 1;

  private static void tri(int H) {
    System.out.println("Start of Triangle #" + caseNum);
    int count = 1;
    int spaces = H - 1;
    for (int i = 0; i < H; i++) {
      System.out.println(" ".repeat(spaces) + "*".repeat(count));
      count += 2;
      spaces--;
    }
    System.out.println("End of Triangle #" + caseNum);
    caseNum++;

  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Eva.class.getResourceAsStream("./eva.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        int H = dataScanner.nextInt();
        tri(H);
      }
    }
  }
}
