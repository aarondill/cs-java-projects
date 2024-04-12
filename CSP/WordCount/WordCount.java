import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordCount {
  static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

  /**
   * Process the input list of chars and return the number of words, lines, vowels
   * and consonants in the input.
   *
   * @return [words, lines, vowels, consonants, alphanumeric, non-alphanumeric]
   *
   *         <pre>
   * Words is the number of chars sequences surrounded by whitespace.
   * Lines is the number of NLs in the input.
   * Vowels is the number of vowels in the input.
   * Consonants is the number of consonants in the input.
   * Alphanumeric is the number of alphanumeric chars in the input.
   * Non-alphanumeric is the number of non-alphanumeric chars in the input,
   * excluding whitespace.
   *         </pre>
   */
  public static int[] process(List<Character> input) {
    int words = 0, lines = 0, vowels = 0, consonants = 0;
    int alphanumeric = 0, nonAlphanumeric = 0;
    for (char c : input) {
      if (c == '\n') lines++;

      if (Character.isWhitespace(c)) words++;
      else if (Character.isLetterOrDigit(c)) {
        alphanumeric++;
        if (Character.isLetter(c)) {
          if (Arrays.binarySearch(VOWELS, Character.toLowerCase(c)) >= 0) {
            vowels++;
          } else consonants++;
        }
      } else nonAlphanumeric++;
    }
    return new int[] {words, lines, vowels, consonants, alphanumeric, nonAlphanumeric};
  }

  public static void main(String... args) {
    System.out.print("""
        Welcome to NewUltraWordCountProExtremeMaxX!
        This program calculates statistics about the input.
        Type DONE on it's own line or close input with CTRL+D to exit.
        Enter a string to be counted:
        """);

    List<Character> chars = new ArrayList<>();
    try (Scanner scan = new Scanner(System.in)) {
      while (scan.hasNextLine()) {
        String line = scan.nextLine();
        if (line.equals("DONE")) break;
        for (char c : line.toCharArray())
          chars.add(c);
        chars.add('\n');
      }
    }

    int[] res = process(chars);
    String[] headers = {"Words", "Lines", "Vowels", "Consonants", //
        "Alphanumeric", "Non-Alphanumeric"};
    String[] output = new String[headers.length];
    for (int i = 0; i < headers.length; i++)
      output[i] = String.format("%s: %d", headers[i], res[i]);
    System.out.println(String.join(", ", output));
  }
}
