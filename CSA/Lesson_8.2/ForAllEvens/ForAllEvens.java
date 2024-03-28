import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Primary java class: ForAllEvens
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    03/26/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: find even numbers in a 2D array
 *
 */
public class ForAllEvens {
  public static void main(String... args) throws IOException {
    List<Path> files = new ArrayList<>();
    try (DirectoryStream<Path> ds = Files.newDirectoryStream(Path.of("."))) {
      for (Path f : ds) {
        if (!f.getFileName().toString().toLowerCase().startsWith("2DArrInt".toLowerCase())) continue;
        files.add(f);
      }
    } ;
    if (files.size() == 0) throw new FileNotFoundException("2DArrInt.dat");
    for (Path path : files) {
      try (Scanner f = new Scanner(path)) {
        int R = f.nextInt(), C = f.nextInt();
        int[][] grid = new int[R][C];
        for (int r = 0; r < R; r++)
          for (int c = 0; c < C; c++)
            grid[r][c] = f.nextInt();
        Traversals.rowMajorTraversalNested(grid);
        Traversals.forAllEven(grid);
      }
      System.out.println();
    }
  }
}
