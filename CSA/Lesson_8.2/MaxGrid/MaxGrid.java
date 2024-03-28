import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Primary java class: MaxGrid
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    03/26/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class MaxGrid {
  public static void main(String... args) throws IOException {
    String[] files = {"2DArrIntB.dat", "2DArrInt.dat"};
    Path path = Stream.of(files).map(Path::of).filter(Files::exists).findFirst().orElse(null);
    if (path == null)
      throw new FileNotFoundException("The directions said to use 2DArrIntB.dat, but that file does not exist.");
    try (Scanner f = new Scanner(path)) {
      int R = f.nextInt(), C = f.nextInt();
      int[][] grid = new int[R][C];
      for (int r = 0; r < R; r++)
        for (int c = 0; c < C; c++)
          grid[r][c] = f.nextInt();
      Traversals.rowMajorTraversalNested(grid);
      System.out.printf("The maximum value is %d\n", Traversals.maxGrid(grid));
    }
  }
}
