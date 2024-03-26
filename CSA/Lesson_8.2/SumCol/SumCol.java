import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Primary java class: SumCol
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
public class SumCol {
  public static void main(String... args) throws FileNotFoundException {
    try (Scanner f = new Scanner(new File("2DArrInt.dat"))) {
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
      Traversals.rowMajorTraversalNested(grid);
      System.out.println();
      System.out.printf("The sum of the values in column %d is %d\n", col, Traversals.sumCol(grid, col));
    }
  }
}
