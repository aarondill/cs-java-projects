import java.util.Scanner;

/**
 * Primary java class: Names
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    09/21/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Write a program to input and instantiate two String objects containing the
 * first and last name of a person of your own choosing, a celebrity,
 * interesting person, or fictional character.
 * 
 * Output the two names in the following ways:
 * First Last
 * The sum of the lengths of the two names
 * The two initials side by side
 * The comparison of the two original names
 * The index position in the last name of the last letter of the first name, -1
 * if not there
 * The index position in the first name of the last letter of the last name, -1
 * if not there
 * A new first and last name made of the following:
 * First half of first + last half of last
 * First half of last + last half of first
 * Requirement - all of the original name letters must be used in the new names.
 * Hint: create two int variables called mid1 and mid2 to contain the midpoint
 * value of each name to be used in creating the new names as described above.
 * For example, the midpoint of “Carl” is 2 (4 / 2) and the midpoint of “Sagan”
 * is 2 (5 / 2)
 * 
 */
public class Names {
  private static String input(String prompt, Scanner scan) {
    System.out.print(prompt);
    return scan.nextLine();
  };

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      String fName = input("Enter first name: ", scan), lName = input("Enter last name: ", scan);
      int fLength = fName.length(), lLength = lName.length();
      int fMid = fLength / 2, lMid = lLength / 2;

      System.out.printf("%s %s\n", fName, lName);
      System.out.printf("%d\n", fLength + lLength);
      System.out.printf("%c%c\n", fName.charAt(0), lName.charAt(0));
      System.out.printf("%d\n", fName.compareTo(lName));
      // The index position in the last name of the last letter of the first name
      System.out.printf("%d\n", lName.indexOf(fName.charAt(fLength - 1)));
      // The index position in the first name of the last letter of the last name
      System.out.printf("%d\n", fName.indexOf(lName.charAt(lLength - 1)));
      String newFirst = fName.substring(0, fMid) + lName.substring(lMid); // First half of first + last half of last
      String newLast = lName.substring(0, lMid) + fName.substring(fMid); // First half of last + last half of first
      System.out.printf("%s %s\n", newFirst, newLast);

    }
  }
}
