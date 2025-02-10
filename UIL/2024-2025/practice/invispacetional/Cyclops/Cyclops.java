import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cyclops {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "cyclops.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    int h = scan.nextInt();
    int w = scan.nextInt();
    int power = scan.nextInt();
    scan.nextLine();
    List<Integer> grid = new ArrayList<>();
    for (int y = 0; y < h; y++) {
      String line = scan.nextLine();
      for (int x = 0; x < w; x++) {
        grid.add(line.charAt(x) - '0');
      }
    }
    int initialSize = grid.size();
    grid.sort(Integer::compareTo); // Sort the grid, smallest to largest.
    while (power >= 0 && grid.size() > initialSize / 2) {
      power -= grid.remove(0);
    }
    if (power < 0) {
      System.out.println("Better Call Iceman.");
    } else {
      System.out.println("Made it with " + power + " power to spare.");
    }
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
