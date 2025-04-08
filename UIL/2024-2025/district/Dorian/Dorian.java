import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dorian {
  private static final String INPUT_FILE = "dorian.dat";

  final static int WIDTH = 89;
  final static int INDENT = 6;

  private static void each(Scanner scan) {
    // Parse the input:
    String[] words = scan.nextLine().splitWithDelimiters("\\s+", 0);

    String line = "";
    // Wrap input to 89 characters; indent each following line by 6 spaces.
    for (String word : words) {
      boolean isWhitespace = word.matches("\\s+");
      if (line.length() + word.length() > WIDTH) { // If the line is too long, move to the next line.
        System.out.println(line);
        line = " ".repeat(INDENT);
      } else if (isWhitespace) { // If the line isn't too long, print the whitespace (may result in trailing spaces, this is okay).
        if (line.isBlank()) continue;
        line += word;
      }
      if (!isWhitespace) line += word; // we always print the word
    }
    if (!line.isBlank()) System.out.println(line); // print the last line
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
