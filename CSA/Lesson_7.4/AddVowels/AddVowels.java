import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Primary java class: AddVowels
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/21/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program that will allow the user to enter a single
 * word. Place each individual letter of that word into an ArrayList that holds
 * String objects. Using a loop of your choice, traverse the ArrayList and for
 * each letter in the ArrayList that is a vowel add that same vowel to the list
 * at that location in the list. Then, using a for each loop, traverse the list
 * again and print each of the letters. The output should be a word where every
 * vowel appears twice.
 */
public class AddVowels {
  public static void main(String... args) {
    String word;
    System.out.print("Enter a word: ");
    try (Scanner scan = new Scanner(System.in)) {
      word = scan.next(); // use nextline?
    }
    // word.chars().mapToObj(c -> (char) c).<Character>mapMulti((c, add) -> {
    //   add.accept(c);
    //   switch (c) {
    //     case 'a', 'e', 'i', 'o', 'u': // and sometimes y
    //     case 'A', 'E', 'I', 'O', 'U': // and sometimes Y
    //       add.accept(c);
    //   }
    // }).forEach(System.out::print);

    List<String> text = new ArrayList<>(); // Should be List<Character>
    for (char c : word.toCharArray()) {
      String cs = String.valueOf(c); // Use Characters!
      text.add(cs);
      switch (c) {
        case 'a', 'e', 'i', 'o', 'u': // and sometimes y
        case 'A', 'E', 'I', 'O', 'U': // and sometimes Y
          text.add(cs);
      }
    }
    text.forEach(System.out::print);
    System.out.println();
  }
}
