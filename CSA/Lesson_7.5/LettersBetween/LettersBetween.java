import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Supplier;

/**
 * Primary java class: LettersBetween
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/23/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 * Write a program that will allow the user to enter a single word and a single
 * letter. Print the number of letters between the first occurrence of that
 * letter and the last occurrence of the letter. Print that the letter only
 * appears once in the word, if that is the case. If the target letter is not in
 * the word, then print that the letter is not present. You must use an
 * ArrayList and two static methods named indexOf and lastIndexOf. indexOf
 * should return the index number of the first occurrence of its target letter
 * and lastIndexOf should return the index value of the last occurrence of the
 * target letter. Do not use any String class methods to complete indexOf or
 * lastIndexOf. Several sample runs are shown below:
 * 
 * <pre>
 * Enter your word: remember
 * Enter a letter: r
 * There are 6 letters between the first and last occurrence of r
 * Enter your word: remember
 * Enter a letter: e
 * There are 4 letters between the first and last occurrence Of e
 * Enter your word: occurrence
 * Enter a letter: r
 * There are 0 letters between the first and last occurrence of r
 * Enter your word: occurrence
 * Enter a letter: n
 * n only appears one time in occurrence
 * Enter your word: computer
 * Enter a letter: a
 * a is not present in computer
 * </pre>
 * 
 * 
 */
public class LettersBetween {
  private static <T> T next(String prompt, Supplier<T> supplier) {
    System.out.print(prompt);
    return supplier.get();
  }

  public static void main(String... args) {
    String word, letter;
    try (Scanner kb = new Scanner(System.in)) {
      word = next("Enter your word: ", kb::next);
      letter = next("Enter a letter: ", kb::next);
    }
    ArrayList<String> list = new ArrayList<String>();
    for (char c : word.toCharArray())
      list.add(String.valueOf(c)); // why ArrayList String?
    int i = indexOf(list, letter);
    String msg = letter + " is not present in " + word;
    if (i != -1) {
      int j = lastIndexOf(list, letter);
      if (i == j) msg = letter + " only appears once in " + word;
      else msg = "There are " + (j - i - 1) + " letters between the first and last occurrence of " + letter;
    }
    System.out.println(msg);
  }

  public static <T> int indexOf(ArrayList<T> list, T target) {
    // return list.indexOf(target);
    for (int i = 0; i < list.size(); i++)
      if (list.get(i).equals(target)) return i;
    return -1;
  }

  public static <T> int lastIndexOf(ArrayList<T> list, T target) {
    // return list.lastIndexOf(target);
    for (int i = list.size() - 1; i >= 0; i--)
      if (list.get(i).equals(target)) return i;
    return -1;
  }
}
