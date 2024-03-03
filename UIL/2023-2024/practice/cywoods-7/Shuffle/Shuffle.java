import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Shuffle {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "Shuffle.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    List<String> ingredients = new ArrayList<>(Arrays.asList(scan.nextLine().split("\\s+")));
    int shift = Integer.parseInt(ingredients.removeLast(), 10); // the last element is the shift
    // Handle output:
    for (int i = 0; i < Math.abs(shift); i++) {
      if (shift > 0) ingredients.addFirst(ingredients.removeLast());
      else ingredients.addLast(ingredients.removeFirst());
    }
    System.out.println(String.join(" ", ingredients));
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
