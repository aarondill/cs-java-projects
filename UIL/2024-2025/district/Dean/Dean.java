import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Dean {
  @SuppressWarnings("unused")
  private static long caseNum = 1;
  private static final String INPUT_FILE = "dean.dat";

  // Takes a window [i, j) and expands it [i-1, j+1), [i-2, j+2), etc, until it stops finding palindromes
  // Assumes the window passed in is a palindrome
  public static long countExpandingPalindromes(List<Character> s, int i, int j) {
    long count = 0;
    // we're *still* a palindrome iff the new first and last characters are the same
    // PERF: This is the most important optimization! If you try to expand the
    // window, then test if it's a palindrome, it *will* timeout. This is
    // because we're checking the entire string every time.
    while (s.get(i).equals(s.get(j - 1))) {
      count++;
      if (--i < 0 || ++j > s.size()) break;
    }
    return count;
  }

  /**
   * Counts the number of palindromes in the given string. Loops each window of
   * len 2 and 3, then if it finds a palindrome, expands the window until it's no
   * longer a palindrome.
   *
   * @param s the string to count palindromes in
   * @return the number of palindromes in the given string
   */
  public static long countPalindromes(List<Character> s, int len) {
    // for each window of length len
    return IntStream.rangeClosed(0, s.size() - len).parallel().filter(idx -> {
      final int end = idx + len - 1;
      for (int i = idx; i < idx + len; i++) {
        if (s.get(i) != s.get(end - i)) return false;
      }
      return true;
    }).mapToLong(idx -> countExpandingPalindromes(s, idx, idx + len)).sum();
  }

  public static long countPalindromes(String str) {
    // This is more efficient because we can use subList instead of copying the substring
    List<Character> s = str.chars().mapToObj(c -> (char) c).toList();
    return countPalindromes(s, 2) + countPalindromes(s, 3);
  }

  private static void each(Scanner scan) {
    String s = scan.nextLine();
    long count = s.length() + countPalindromes(s);// One letter palindromes count
    System.out.println(count);
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      long dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (long i = 0; i < dataCount; i++, caseNum++)
        each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
