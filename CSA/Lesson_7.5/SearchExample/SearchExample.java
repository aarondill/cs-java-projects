import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

/**
 * Primary java class: SearchExample
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
 */
public class SearchExample {
  private static <T> T next(String prompt, Supplier<T> supplier) {
    System.out.print(prompt);
    return supplier.get();
  }

  public static void main(String[] args) {
    String target, replacement;
    String[] words;
    try (Scanner kb = new Scanner(System.in)) {
      words = next("Enter a sentance: ", kb::nextLine).split("\\s+");
      target = next("Which word would you like to replace? ", kb::next);
      replacement = next("What is the new word? ", kb::next);
    }

    List<String> list = new ArrayList<String>();
    for (String word : words)
      list.add(word);
    //Call the search method to find the index of the word to be replaced.
    int loc = search(list, target);

    //if location is greater than -1 then the target word is in the sentence
    //and we replace it with the replacement word.
    if (loc >= 0) list.set(loc, replacement);
    //The target word was not in the sentence.
    else System.out.println(target + " is not in the sentence.");

    //Now, print the modified sentence.
    System.out.println(String.join(" ", list));
  }

  public static <T> int search(List<T> list, T target) {
    for (int i = 0; i < list.size(); i++)
      if (list.get(i).equals(target)) return i;
    return -1;
  }
}
