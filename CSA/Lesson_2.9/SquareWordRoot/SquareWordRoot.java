import java.util.Scanner;

/**
 * Primary java class: SquareWordRoot
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    09/25/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Lab 2.9.4 - SquareWordRoot – OK, this problem is a little silly. We are going
 * to find the square root of a word! Let's pretend that the "square root" of a
 * word is the letter indexed by the square root of its length. Consider the
 * word applejack. Applejack has nine letters. The square root of nine is three.
 * So the "square root" of applejack is l. That works great for words with a
 * length that is a perfect square. What about television? Television has ten
 * letters. The square root of 10 is approximately 3.162277660. Obviously we
 * can't use that decimal value as an index for a String. For the purposes of
 * this problem let's round that value to the nearest whole number. In this case
 * that would be 3. So the "square root" of television is e.
 * 
 * Just to keep things simple, assume that none of the words that the user might
 * enter will be one letter words. Every word will have two or more letters.
 * 
 * Write a program that will prompt the user for a word and then prints the
 * "square root" of that word. Your output must include the quotation marks
 * around the words "square root". Here are sample runs using applejack and
 * television.
 *
 * <pre>
 * Enter your word: applejack
 * The "square root" of applejack is 1
 * Enter your word: television
 * The "square root" of television is e
 * </pre>
 * 
 */
public class SquareWordRoot {
  public static String squareRoot(String word) {
    int i = (int) (Math.sqrt(word.length()) + 0.5);
    return word.substring(i, i + 1);
  }

  public static void main(String... args) {
    try (Scanner input = new Scanner(System.in)) {
      System.out.print("Enter your word: ");
      String word = input.nextLine();
      System.out.println("The \"square root\" of " + word + " is " + squareRoot(word));
    }
  }
}
