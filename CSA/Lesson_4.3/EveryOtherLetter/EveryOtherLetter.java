import java.util.Scanner;

/**
 * Primary java class: EveryOtherLetter
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/09/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Lab 4.3.2 – EveryOtherLetter - Write a program that will prompt the user for
 * a word and then print every other letter in that word, beginning with the
 * first, all on the same line. You must declare and use a new String object to
 * store every other letter. Print the new String, do not print within the body
 * of the for loop. (see Topic 4.3 Practice Labs
 *
 */
public class EveryOtherLetter {
  public static void main(String... args) {
    String word;
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("Enter the word: ");
      word = scan.nextLine();
    }
    String s = "";
    for (int i = 0; i < word.length(); i += 2) {
      s += (word.substring(i, i + 1));
    }
    System.out.println(s);
  }
}
