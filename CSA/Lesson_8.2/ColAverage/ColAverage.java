import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Primary java class: ColAverage
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    03/22/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: sum a row
 *
 */
public class ColAverage {
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
      int col = 0;
      try (Scanner input = new Scanner(System.in)) {
        do {
          System.out.print("Enter column number ==> ");
          col = input.nextInt();
          if (col < 0 || col >= C) System.out.println("Invalid column number. Try again.");
        } while (col < 0 || col >= C);
      }
      System.out.printf("The average of the values in col %d is %s\n", col, Traversals.colAvg(grid, col));
    });
  }
}
