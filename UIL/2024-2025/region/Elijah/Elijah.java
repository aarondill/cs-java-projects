import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Elijah {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "elijah.dat";

  // The constructor is called on each case
  private Elijah(Scanner scan) {
    int height = scan.nextInt(), width = scan.nextInt();
    scan.nextLine();
    char[][] grid = new char[height][width];
    for (int y = 0; y < height; y++) {
      String line = scan.nextLine();
      grid[y] = line.toCharArray();
    }
    long rot = scan.nextLong() % 360;
    long times = (rot / 90);

    for (int i = 0; i < times; i++) {
      char[][] res = new char[grid[0].length][grid.length];
      for (int y = 0; y < grid.length; y++) {
        for (int x = 0; x < grid[y].length; x++) {
          res[x][res[0].length - 1 - y] = grid[y][x];
        }
      }
      grid = res;
    }
    for (int y = 0; y < grid.length; y++) {
      for (int x = 0; x < grid[y].length; x++) {
        System.out.print(grid[y][x]);
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        new Elijah(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
