import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Arusha {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "arusha.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    String word = scan.next();
    String instructions = scan.next();
    int shift = 0;
    for (char c : instructions.toCharArray()) {
      if (c == 'L') shift--;
      else if (c == 'R') shift++;
    }
    List<String> letters = new ArrayList<>(Arrays.asList(word.split("")));
    Collections.rotate(letters, shift);
    System.out.println(String.join("", letters));
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
