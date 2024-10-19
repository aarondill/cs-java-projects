import java.util.Scanner;

public class Solution {

  private static char flip(char c) {
    if (!Character.isLetter(c)) return c;
    if (Character.isLowerCase(c)) return (char) ('a' + ('z' - c));
    else return (char) ('A' + ('Z' - c));
  }

  private static void each(Scanner scan) {
    // Parse the input:
    String input = scan.nextLine();
    input.chars().mapToObj(c -> (char) c).map(c -> {
      if (!Character.isLetter(c)) return c;
      if (Character.isUpperCase(c)) return Character.toLowerCase(c);
      return Character.toUpperCase(c);
    }).map(Solution::flip).forEach(System.out::print);
    System.out.println();
    // Handle output:
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++)
        each(scan);
    }
  }
}
