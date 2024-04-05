import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Juana {
  private static int caseNum = 1;
  private static final String INPUT_FILE = "juana.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    int h = scan.nextInt(), w = scan.nextInt();
    scan.nextLine();
    int[][] grid = new int[h][w];
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++)
        grid[i][j] = scan.nextInt();
      scan.nextLine();
    }
    int y = scan.nextInt() - 1, x = scan.nextInt() - 1; // 1-indexed input
    int dx = scan.nextInt() - 1, dy = scan.nextInt() - 1; // the width and height of the selection (including x,y)
    scan.nextLine();
    // Handle output:
    System.out.print("Test case #" + caseNum + ": ");
    if (x < 0 || x >= w || y < 0 || y >= h) System.out.println("Unable to extract requested size!");
    else if (x + dx >= w || y + dy >= h) System.out.println("Unable to extract requested size!");
    else {
      System.out.println();
      for (int j = y; j <= y + dy; j++) {
        for (int i = x; i <= x + dx; i++) {
          System.out.printf("%5d", grid[j][i]);
        }
        System.out.println();
      }
    }
    System.out.println("--------------------");
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
