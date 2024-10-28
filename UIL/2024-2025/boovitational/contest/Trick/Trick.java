import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Trick {
  private static final String INPUT_FILE = "trick.dat";

  private static void each(String line) {
    Matcher matcher = Pattern.compile("^(?<first>.+)\\s+(?<op>AND|OR)\\s+(?<second>.*)$").matcher(line);
    if (!matcher.matches()) throw new IllegalArgumentException("Invalid line: " + line);
    String first = matcher.group("first");
    String second = matcher.group("second");
    String op = matcher.group("op");

    // Invert the first and second
    if (first.startsWith("not ")) first = first.substring("not ".length());
    else first = "not " + first;

    if (second.startsWith("not ")) second = second.substring("not ".length());
    else second = "not " + second;

    // Invert the operator
    op = switch (op) {
      case "AND" -> "OR";
      case "OR" -> "AND";
      default -> throw new IllegalArgumentException("Invalid operator: " + op);
    };
    System.out.printf("not (%s %s %s)\n", first, op, second);
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      while (scan.hasNextLine())
        each(scan.nextLine());
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
