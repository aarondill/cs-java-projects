import java.util.Scanner;

/**
 * Primary java class: Palindromes
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/09/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: A palindrome is any word that is spelled the same both
 * forwards and backwards. Two examples are civic and radar. Write a program
 * that will determine if a word entered by the user is a palindrome
 *
 */
public class Palindromes {
  private static boolean isPalindrome(String s) {
    String tmp = "";
    for (int i = s.length() - 1; i >= 0; i--)
      tmp += s.substring(i, i + 1);
    return s.equals(tmp);
    // return s.equals(new StringBuilder(s).reverse().toString());
  }

  public static void main(String... args) {
    String word;
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("Enter a word: ");
      word = scan.nextLine();
    }
    if (isPalindrome(word)) System.out.println(word + " is a palindrome.");
    else System.out.println(word + " is not a palindrome.");

  }
}
