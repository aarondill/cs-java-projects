import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.function.Consumer;

public class ThereExists2D {
  private static void withScan(final InputStream in, final Consumer<Scanner> c) {
    try (Scanner f = new Scanner(in)) {
      c.accept(f);
    }
  }

  private static void withScan(final String filename, final Consumer<Scanner> c) {
    try (Scanner f = new Scanner(new File(filename))) {
      c.accept(f);
    } catch (FileNotFoundException e) {
      throw new RuntimeException("Could not find file: " + filename);
    }
  }

  public static void main(String... args) throws FileNotFoundException {
    withScan("2DArrInt.dat", f -> {
      int R = f.nextInt(), C = f.nextInt();
      int[][] grid = new int[R][C];
      for (int r = 0; r < R; r++)
        for (int c = 0; c < C; c++)
          grid[r][c] = f.nextInt();
      Traversals.rowMajorTraversalNested(grid);
      try (Scanner input = new Scanner(System.in)) {
        while (true) {
          System.out.print("Enter search target ==> ");
          int target = input.nextInt();
          if (target == -999) break;
          if (Traversals.thereExists(grid, target)) System.out.println(target + " is in the grid.");
          else System.out.println(target + " is not in the grid.");
        }
      }
    });
  }
}
