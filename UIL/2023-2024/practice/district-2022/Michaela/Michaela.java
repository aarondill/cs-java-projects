import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Michaela {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "michaela.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    String line = scan.nextLine();
    System.out.printf("Message #%d: %s\n", caseNum,
        line.chars().mapToObj(c -> Integer.toBinaryString(Character.toUpperCase(c)).replaceFirst("^0*", "")
            .replaceAll("1", "-").replaceAll("0", ".")).collect(Collectors.joining(" ")));
    // Handle output:
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
