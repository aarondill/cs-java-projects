import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Crypt {
  private static final String INPUT_FILE = "crypt.dat";

  private static void each(Scanner scan) {
    String keyword = scan.next().toUpperCase();
    String message = scan.nextLine().trim();
    int width = keyword.length();
    int height = message.length() / width;

    // Create a grid of width x height
    List<List<Character>> columns = new ArrayList<>(width);
    // A dummy value is needed to be able to use set() on the list
    for (int x = 0; x < width; x++)
      columns.add(new ArrayList<>(Collections.nCopies(height, null)));

    { // Fill the columns with the message
      int i = 0;
      for (int y = 0; y < height; y++)
        for (int x = 0; x < width; x++)
          columns.get(x).set(y, message.charAt(i++));
    }

    for (int x = 0; x < width; x++)
      columns.get(x).addFirst(keyword.charAt(x));
    columns.sort((a, b) -> a.get(0).compareTo(b.get(0))); // sort by keyword letter (first char)
    columns.forEach(List::removeFirst); // remove keyword letter (first char)

    columns.forEach(l -> l.forEach(System.out::print));
    System.out.println();
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
