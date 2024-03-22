/**
 * Primary java class: Traversals
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    03/22/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Do some traversals
 *
 */

public class Traversals {

  public static void rowMajorTraversalNested(int[][] grid) {
    if (grid == null) return;
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++)
        System.out.print(grid[r][c] + " ");
      System.out.println();

    }
  }

  public static void colMajorTraversalNested(int[][] grid) {
    if (grid == null) return;
    for (int c = 0; c < grid[0].length; c++) {
      for (int r = 0; r < grid.length; r++)
        System.out.print(grid[r][c] + " ");
      System.out.println();
    }
  }

  public static void rowMajorTraversalForEach(int[][] grid) {
    if (grid == null) return;
    for (int[] row : grid) {
      for (int x : row)
        System.out.print(x + " ");
      System.out.println();
    }
  }
}
