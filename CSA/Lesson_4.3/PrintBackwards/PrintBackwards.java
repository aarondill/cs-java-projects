import java.util.Scanner;

/**
 * Primary java class: PrintBackwards
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/09/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class PrintBackwards {
  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("Enter a word: ");
      String str = scan.next();
      System.out.print(str + " printed backwards is ");
      // System.out.println(new StringBuffer(str).reverse().toString());
      for (int i = str.length() - 1; i >= 0; i--)
        System.out.print(str.substring(i, i + 1));
    }
  }
}
