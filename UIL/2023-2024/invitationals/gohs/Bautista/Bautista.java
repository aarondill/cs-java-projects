import java.util.Scanner;

/**
 * Primary java class: Bautista
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
public class Bautista {
  public static void main(String... args) {
    try(Scanner dataScanner = new Scanner( Bautista.class.getResourceAsStream( "./bautista.dat" ) )){
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        String s = dataScanner.nextLine();
        s = s.replaceAll("[aeiou]", "OUCH!!!");
        System.out.println(s);
      }
    }
  }
}
