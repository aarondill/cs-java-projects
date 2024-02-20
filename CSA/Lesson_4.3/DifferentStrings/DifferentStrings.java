import java.util.Scanner;

/**
 * Primary java class: DifferentStrings
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/09/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Write a program that will allow the user to enter two words. The program
 * should then print if the two words are the same or are different. If they are
 * different, the program should print the position of the first letter that is
 * different. Print the actual position of the differing letters not the index
 * value. For example the third letter in "horse" and "house" is different so
 * your program should print 3.
 *
 */
public class DifferentStrings {
  // Returns the index of the first letter that is different from the second
  // Returns -1 if they are the same
  private static int compare(String first, String second) {
    for (int i = 0; i < first.length() && i < second.length(); i++) {
      String f = first.substring(i, i + 1);
      String s = second.substring(i, i + 1);
      if (!f.equals(s))
        return i;
    }
    if (first.length() != second.length())
      return Math.min(first.length(), second.length());
    return -1;
  }

  public static void main(String[] args) {
    String firstWord, secondWord;
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("First word: ");
      firstWord = scan.nextLine();
      System.out.print("Second word: ");
      secondWord = scan.nextLine();
    }
    int comparison = compare(firstWord, secondWord);
    if (comparison == -1)
      System.out.printf("%s and %s are the same.\n", firstWord, secondWord);
    else
      System.out.printf("%s and %s are not the same. They differ at letter number %d.\n", firstWord, secondWord,
          comparison + 1);

  }
}
