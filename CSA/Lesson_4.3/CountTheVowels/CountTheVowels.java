import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Primary java class: CountTheVowels
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/09/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Lab 4.3.3 – CountTheVowels - Write a program that will prompt the user for a
 * word and then print each vowel in the word and the total number of vowels in
 * the word. You may assume that all of the letters will be lower case. Do not
 * count y as a vowel. (see Topic 4.3 Practice Labs
 *
 */
public class CountTheVowels {
  public static void main(String... args) {
    String word;
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("Enter the word: ");
      word = scan.nextLine();
    }
    Set<String> vowels = Set.of("a", "e", "i", "o", "u");
    ArrayList<String> vowelsInWord = new ArrayList<>();
    for (int i = 0; i < word.length(); i++) {
      String c = word.substring(i, i + 1);
      if (vowels.contains(c))
        vowelsInWord.add(c);
    }
    System.out.println(vowelsInWord.stream().collect(Collectors.joining(" ")));
    System.out.println("Total vowels = " + vowelsInWord.size());
  }
}
