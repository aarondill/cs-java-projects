import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Arusha {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "arusha.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    String[] line = scan.nextLine().split(" ");
    // Handle output:
    List<String> chars = line[0].chars().mapToObj(c -> "" + (char) c).collect(Collectors.toList());
    List<Character> moves = line[1].chars().mapToObj(c -> (char) c).collect(Collectors.toList());

    for (char m : moves) {
      switch (m) {
        case 'L' -> chars.add(chars.remove(0));
        case 'R' -> chars.add(0, chars.removeLast());
        default -> throw new RuntimeException("Invalid move: " + m);
      }
    }
    System.out.println(String.join("", chars));

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
