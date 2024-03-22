import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Primary java class: Load2DArrayFromFile
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    03/22/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Load2DArrayFromFile {
  private static void withScan(final String filename, final Consumer<Scanner> c) {
    try (Scanner f = new Scanner(new File(filename))) {
      c.accept(f);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + filename);
    }
  }

  public static void main(String... args) throws FileNotFoundException {
    withScan("2DArrInt.dat", f -> {
      int R = f.nextInt(), C = f.nextInt();
      int[][] grid = new int[R][C];
      for (int r = 0; r < R; r++)
        for (int c = 0; c < C; c++)
          grid[r][c] = f.nextInt();
      Traversals.rowMajorTraversalForEach(grid);
    });
  }
}
