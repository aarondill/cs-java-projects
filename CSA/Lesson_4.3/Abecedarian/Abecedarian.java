import java.util.Scanner;

/**
 * Primary java class: Abecedarian
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
public class Abecedarian {
  public static void main(String... args) {
    String w;
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("Enter the word: ");
      w = scan.next();
    }
    /*
     * declare a boolean variable and an int variable for the index
     * while(characters are in alpha order AND there are more characters)
     * get the next pair of characters
     * if(characters are NOT in alpha order)
     * change boolean variable to false
     * add one to the index
     *
     * if(boolean variable is true)
     * print(is abecedarian)
     * else
     * print(is not abecedarian)
     */
    boolean is = true;
    int i = 0;
    while (is && i < w.length() - 1) {
      String c1 = w.substring(i, i + 1);
      String c2 = w.substring(i + 1, i + 2);
      if (c1.compareTo(c2) > 0)
        is = false;
      i++;
    }

    if (is)
      System.out.println(w + " is an abecedarian word.");
    else
      System.out.println(w + " is not an abecedarian word.");
  }
}
