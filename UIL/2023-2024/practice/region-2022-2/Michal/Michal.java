import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Michal {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "michal.dat";

  private static String digit(int d) {
    return switch (d) {
      case 0 -> """
          ***
           _
          | |
          |_|

          ***
          """;
      case 1 -> """
          ***

            |
            |

          ***
          """;
      case 2 -> """
          ***
           _
           _|
          |_

          ***
          """;
      case 3 -> """
          ***
           _
           _|
           _|

          ***
          """;
      case 4 -> """
          ***

          |_|
            |

          ***
          """;
      case 5 -> """
          ***
           _
          |_
           _|

          ***
          """;
      case 6 -> """
          ***
           _
          |_
          |_|

          ***
          """;
      case 7 -> """
          ***
           _
            |
            |

          ***
          """;
      case 8 -> """
          ***
           _
          |_|
          |_|

          ***
          """;
      case 9 -> """
          ***
           _
          |_|
           _|

          ***
          """;
      default -> throw new IllegalArgumentException("Invalid digit: " + d);
    };
  }

  // Height is constant (6)
  private static void add(List<List<String>> output, String input) {
    String[] lines = input.split("\n");
    int width = 0;
    for (String line : lines)
      width = Math.max(width, line.length());
    for (int i = 0; i < 6; i++) {
      String line = i < lines.length ? lines[i] : " ";
      String spacing = " ".repeat(width - line.length());
      output.get(i).add(line + spacing);
    }
  }

  private static void each(Scanner scan) {
    // Parse the input:
    int[] nums = Stream.of(scan.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
    // Handle output:
    List<List<String>> output = new ArrayList<>();
    for (int i = 0; i < 6; i++)
      output.add(new ArrayList<>());
    add(output, "*\n".repeat(6));

    for (int n : nums)
      add(output, digit(n));

    add(output, "*\n".repeat(6));
    for (var row : output)
      System.out.println(String.join("", row));
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
