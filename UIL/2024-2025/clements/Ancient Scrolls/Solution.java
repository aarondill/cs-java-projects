import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
  private static boolean valid(char[] data) {
    Deque<Character> stack = new ArrayDeque<>(); // Currently "open" characters
    for (char c : data) {
      if (Character.isLowerCase(c)) {
        stack.push(c); // Open the character
      } else {
        if (stack.isEmpty()) return false; // We've found a close, but no open
        char top = stack.pop();
        // We've found a close, but it doesn't match the open
        if (top != Character.toLowerCase(c)) return false;
      }
    }
    // We've found a close for every open
    return stack.isEmpty();
  }

  private static void each(Scanner scan) {
    char[] data = scan.nextLine().toCharArray();
    System.out.println(valid(data) ? "YES" : "NO");
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++)
        each(scan);
    }
  }
}
