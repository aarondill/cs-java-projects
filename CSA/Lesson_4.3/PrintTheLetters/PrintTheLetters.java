import java.util.Scanner;

/**
 * Primary java class: PrintTheLetters
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
public class PrintTheLetters {
  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("Enter the word: ");
      String word = scan.nextLine();
      // word.chars().forEach(c -> System.out.println((char)c));
      for (int i = 0; i < word.length(); i++) {
        System.out.println(word.substring(i, i + 1));
      }

    }
  }
}
