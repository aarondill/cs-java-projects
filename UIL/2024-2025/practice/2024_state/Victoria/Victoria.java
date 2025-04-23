import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Victoria {
  private static final String INPUT_FILE = "victoria.dat";

  int score = 100;

  private void bonus(int bonusOrPenalty, String why) {
    if (bonusOrPenalty == 0) return;
    // if (bonusOrPenalty > 0) System.out.println("Bonus: " + bonusOrPenalty + " pts " + why);
    // else System.out.println("Penalty: " + bonusOrPenalty + " pts " + why);
    score += bonusOrPenalty;
  }

  public int score(String passPhrase) {
    // A single “word” is a sequence of 1 or more non-blank printable characters and may contain letters, digits, punctuation marks, and all other printable characters.
    List<String> words = Arrays.asList(passPhrase.split("\\s+"));
    long numDistinctLongWords = words.stream().filter(w -> w.length() >= 4).distinct().count();
    // fails 1 or more *rules*
    if (passPhrase.length() < 20 || numDistinctLongWords < 4) { return 0; }
    score = 100;
    if (words.size() > 4) bonus(10 * (words.size() - 4), "extra words"); // 10 pts for each extra word (even short words)
    long upperCaseNumber = words.stream().filter(w -> w.matches(".*[A-Z].*") && w.equals(w.toUpperCase())).count();
    boolean upperCaseBonusValid = upperCaseNumber < (words.size() / 2);
    Set<String> uniqueWords = new HashSet<>(words.size());
    for (String word : words) {
      //  Each word that contains a special character (non-letter and
      //  non-digit), even if it is a single character or a leading or trailing
      //  punctuation mark, results in a 5-point bonus but multiple special
      //  characters within the same word do not add more points.
      if (word.matches(".*[^a-zA-Z0-9].*")) bonus(5, "special character(s)");
      // Each word that contains a digit results in a 5-point bonus but multiple digits within the same word do not add more points.
      if (word.matches(".*\\d.*")) bonus(5, "digit(s)");

      // Each word that contains letters that are only uppercase results in a
      // 10-point bonus but only if less than half of the total words contain
      // letters that are only uppercase. The word may also contain
      // non-letters.
      if (upperCaseBonusValid && word.matches("^[A-Z]+$")) bonus(10, "only uppercase letter(s)");

      // Each complete word that matches another complete word results in a
      // 20-point penalty for the matching pair. Test data will not contain a
      // set of 3 or more words that all match but there can be multiple
      // distinct pairs of matching words
      if (uniqueWords.contains(word)) bonus(-20, "matching words: " + word);
      uniqueWords.add(word);

      // Each complete word with a length greater than 2 characters that matches
      // a prefix or suffix or both of another word results in 10-point penalties
      // for each prefix or suffix match. The word itself is not penalized.
      if (word.length() > 2) {
        for (String otherWord : words) {
          if (otherWord.length() <= 2 || otherWord.equals(word)) continue;
          if (otherWord.startsWith(word) || otherWord.endsWith(word))
            bonus(-10, "prefix/suffix match: " + word + " vs " + otherWord);
        }
      }
    }
    // A passphrase that contains more than one letter and uses only lowercase letters or only uppercase letters, even with digits and special characters results in a 10-point penalty.
    String letters = passPhrase.replaceAll("[^a-zA-Z0-9]", "");
    long numLetters = letters.chars().distinct().count();
    if (numLetters > 1 && (letters.equals(letters.toLowerCase()) || letters.equals(letters.toUpperCase())))
      bonus(-10, "mixed case");

    return score;
  }

  // The constructor is called on each case
  private Victoria(Scanner scan) {
    String passPhrase = scan.nextLine();
    int score = score(passPhrase);
    System.out.print(score + ":");
    if (score >= 150) System.out.println("Excellent");
    else if (score >= 125) System.out.println("Strong");
    else if (score >= 100) System.out.println("Adequate");
    else if (score >= 75) System.out.println("Weak");
    else if (score >= 50) System.out.println("Poor");
    else System.out.println("Unacceptable");
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      while (scan.hasNextLine())
        new Victoria(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
