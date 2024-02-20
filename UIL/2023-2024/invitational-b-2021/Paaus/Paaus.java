import java.util.Scanner;

/**
 * Primary java class: Paaus
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
public class Paaus {
  private static int minNullable(String... strings) {
    int min = Integer.MAX_VALUE;
    for (String string : strings) {
      if (string == null) continue;
      min = Math.min(min, string.length());
    }
    return min;
  }

  private static int lengthNullable(String s) {
    return s == null ? -1 : s.length();
  }

  private static String shortestRepresentation(int number, char missing) {
    String octal = "0" + Integer.toString(number, 8);
    String binary = "0b" + Integer.toString(number, 2);
    String hexadecimal = "0x" + Integer.toString(number, 16).toLowerCase();
    String decimal = Integer.toString(number);
    if (octal.indexOf(missing) > -1) octal = null;
    if (binary.indexOf(missing) > -1) binary = null;
    if (hexadecimal.indexOf(missing) > -1) hexadecimal = null;
    if (decimal.indexOf(missing) > -1) decimal = null;

    int minLen = minNullable(octal, binary, hexadecimal, decimal);
    if (minLen == lengthNullable(octal)) return octal;
    if (minLen == lengthNullable(binary)) return binary;
    if (minLen == lengthNullable(hexadecimal)) return hexadecimal;
    if (minLen == lengthNullable(decimal)) return decimal;
    return "Impossible";
  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Paaus.class.getResourceAsStream("./paaus.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        int number = dataScanner.nextInt();
        char missing = dataScanner.next().charAt(0);
        System.out.printf("Case #%d: %s\n", i, shortestRepresentation(number, missing));
      }
    }
  }
}
