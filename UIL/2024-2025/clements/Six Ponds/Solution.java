import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
  static List<String> vowels = List.of("a", "e", "i", "o", "u", "A", "E", "I", "O", "U");

  static private String replaceAll(String s, String with, String... replacements) {
    StringBuilder ret = new StringBuilder();
    Predicate<Character> shouldReplace = c -> {
      for (String r : replacements)
        if (c == r.charAt(0)) return true;
      return false;
    };
    for (char c : s.toCharArray()) {
      if (shouldReplace.test(c)) ret.append(with);
      else ret.append(c);
    }
    return ret.toString();
  }

  static final List<UnaryOperator<String>> PONDS = List.of( //
      s -> replaceAll(s, "POND", vowels.toArray(String[]::new)), // Replace all vowels with "POND"
      s -> {
        s = replaceAll(s, "POND", vowels.stream().filter((v -> !v.toLowerCase().equals("o"))).toArray(String[]::new)); // Replace all non-o vowels with "POND"
        return s.replaceAll("o", "_").replaceAll("O", "_"); // Replace O with "_"
      }, s -> {
        s = new StringBuilder(s).reverse().toString();
        for (String v : vowels) {
          if (!s.contains(v)) continue;
          String r = String.format("%.2f", Math.sqrt(v.charAt(0)));
          s = s.replaceAll(v, r);
        }
        return s;
      }, // Replace all vowels with their square root
      UnaryOperator.identity(), // Do nothing
      UnaryOperator.identity(), // Do nothing
      (String s) -> {
        StringBuilder ret = new StringBuilder();
        for (char c : s.toCharArray()) {
          if (("" + c).matches("[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]")) ret.append((char) (c - 1));
          else ret.append(c);
        }
        return ret.toString();
      } //all non-vowels replaced by the letter before them
  );

  private static void each(Scanner scan) {
    // Parse the input:
    int n = scan.nextInt();
    String m = scan.nextLine().trim();
    System.out.println(PONDS.get(n - 1).apply(m));
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++)
        each(scan);
    }
  }
}
