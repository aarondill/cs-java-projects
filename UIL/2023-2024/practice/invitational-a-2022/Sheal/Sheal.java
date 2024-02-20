import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Primary java class: Sheal
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/02/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Sheal {
  public static Set<String> permuteString(List<Character> chars) {
    Set<String> possibleNames = new HashSet<>();
    if (chars.size() == 0) {
      possibleNames.add("");
      return possibleNames;
    }

    char initial = chars.get(0); // first character
    Set<String> words = permuteString(chars.stream().skip(1).toList());
    possibleNames.addAll(words); // Include shorter names
    for (String str : words) {
      IntStream.range(0, str.length() + 1) // Range the indices
          .mapToObj(i -> str.substring(0, i) + initial + str.substring(i)) // Insert the initial in all positions
          .forEach(possibleNames::add); // add newly created names
    }
    return possibleNames;
  }

  public static String sheal(String s, int k) {
    // Collect all permutations of chars into possibleNames
    List<Character> chars = s.chars().mapToObj(x -> (char) x).toList();
    // Remove the empty string, since it's not a permitted solution
    List<String> possibleNames =
        permuteString(chars).stream().filter(str -> str.length() > 0).sorted().collect(Collectors.toList());
    return possibleNames.get(k - 1); // one indexed!
  }

  public static void main(String... args) {
    //     Input: Input will begin with a single integer T(T <= 10), the number of test cases to follow. The following T lines will each
    // contain one test case. Each test case consists of a string of available letters S (|S| <= 8), and Sheal’s choice of K. K is guaranteed
    // to be less than or equal to the number of possible names.
    try (Scanner scan = new Scanner(Sheal.class.getResourceAsStream("./sheal.dat"))) {
      int t = scan.nextInt();
      for (int i = 0; i < t; i++) {
        String s = scan.next();
        int k = scan.nextInt();
        System.out.println(Sheal.sheal(s, k));
      }

    }
  }
}
