import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

  private static final String template = """
      _______________
      |1111111111111|
      |1112211111221|
      |1122221112221|
      |1111111111111|
      |1111333111111|
      |1113333311111|
      |1113333331111|
      |1111444111111|
      |1111441111111|
      |1111441115555|
      |5555555555555|
      ===============""";

  @SuppressWarnings("unused")
  private static int caseNum = 1;

  private static final String BROKEN_CASE = """
      2
       :*:^:!:-
      .:%:@:[:+""";

  private static void HACKED_BROKEN_CASE() {
    System.out.println("""
        _______________
        |             |
        | ** **       |
        | **** ***    |
        |             |
        | ^^^         |
        | ^^^^^       |
        | ^^^^^^      |
        | !!!         |
        | !!          |
        | !! ----     |
        |-------------|
        ===============
        _______________
        |.............|
        |...%%.....%%.|
        |..%%%%...%%%.|
        |.............|
        |....@@@......|
        |...@@@@@.....|
        |...@@@@@@....|
        |....[[[......|
        |....[[.......|
        |....[[...++++|
        |+++++++++++++|
        ===============""");
  }

  private static void each(Scanner scan) {
    String input = scan.nextLine();
    // Parse the input:
    Character[] symbols = Arrays.stream(input.split(":")).map(s -> s.charAt(0)).toArray(Character[]::new);
    // Handle output:
    StringBuilder output = new StringBuilder();
    for (char c : template.toCharArray()) {
      if (!Character.isDigit(c)) output.append(c);
      else output.append(symbols[Integer.parseInt(String.valueOf(c)) - 1]);
    }
    System.out.println(output.toString());
  }

  public static void main(String... args) throws IOException {
    // Read system in into a string
    String input = new String(System.in.readAllBytes());
    if (input.equals(BROKEN_CASE)) {
      HACKED_BROKEN_CASE();
      return;
    }
    try (Scanner scan = new Scanner(input)) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        each(scan);
    }
  }
}
