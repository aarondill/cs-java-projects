import java.util.Scanner;

/**
 * Primary java class: Denis
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    12/04/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Denis {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Denis.class.getResourceAsStream("./denis.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        String line = dataScanner.nextLine();
        String[] matches = line.split("/");
        int num = Integer.parseInt(matches[0]);
        int denom = Integer.parseInt(matches[1]);
        int startNum = num, startDenom = denom;

        boolean isNeg = num < 0 ^ denom < 0;
        num = Math.abs(num);
        denom = Math.abs(denom);
        for (int j = 2; j <= Math.max(num, denom); j++) {
          if (num % j == 0 && denom % j == 0) {
            num /= j;
            denom /= j;
            j = 1;
          }
        }
        System.out.printf("%d/%d reduced is %d/%d\n", startNum, startDenom, isNeg ? -num : num, denom);
      }
    }
  }
}
