import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Magic {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "magic.dat";

  static Map<String, String> map = Map.of( //
      "ED AB EE DB", "rpm", //
      "4D 5A", "exe", //
      "25 50 44 46 2D", "pdf", //
      "23 40 7E 5E", "vbs", //
      "CA FE BA BE", "class", //
      "7F 45 4C 46", "elf", //
      "42 43", "bc", //
      "D0 CF 11 E0 A1 B1 1A E1", "msi"//
  );

  private static String hexBytesToString(String content) {
    return Arrays.stream(content.split(" ")) //
        .filter(Predicate.not(String::isEmpty)) //
        .map(c -> Integer.parseInt(c, 16)) //
        .map(Character::toString) //
        .collect(Collectors.joining());
  }

  private static void each(Scanner scan) {
    String content = scan.nextLine();
    String magic = map.keySet().stream().filter(content::startsWith).findFirst().orElse(null);
    if (magic == null) System.out.println(content);
    else {
      String unsafeExtension = map.get(magic);
      content = content.substring(magic.length()); // remove magic
      System.out.printf("BAD_%s.%s\n", hexBytesToString(content), unsafeExtension);
    }
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      while (scan.hasNextLine())
        each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
