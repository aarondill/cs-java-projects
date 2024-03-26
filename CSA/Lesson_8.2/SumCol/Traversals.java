import java.util.Objects;

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

  public static int sumRow(int[][] grid, int row) {
    if (grid == null) return -999;
    if (row < 0 || row >= grid.length) return -999;
    int sum = 0;
    for (int c = 0; c < grid[row].length; c++)
      sum += grid[row][c];
    return sum;
  }

  public static int sumCol(int[][] grid, int col) {
    if (grid == null) return -999;
    if (col < 0 || col >= grid.length) return -999;
    int sum = 0;
    for (int r = 0; r < grid.length; r++)
      sum += grid[r][col];
    return sum;
  }

  public static double colAvg(int[][] grid, int col) {
    Objects.requireNonNull(grid);
    double sum = 0, count = 0;
    for (int r = 0; r < grid.length; r++) {
      sum += grid[r][col];
      count++;
    }
    return sum / count;
  }

  public static int minGrid(int[][] grid) {
    if (grid == null) return -999;
    if (grid.length == 0 || grid[0].length == 0) return -999;
    int min = grid[0][0];
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++) {
        if (grid[r][c] < min) min = grid[r][c];
      }
    }
    return min;
  }

  public static boolean thereExists(int[][] grid, int target) {
    for (int r = 0; r < grid.length; r++) {
      System.out.println("Search row " + r);
      if (search(grid[r], target)) return true;
    }
    System.out.println("Target was not found");
    return false;
  }

  public static boolean search(int[] list, int target) {
    for (int n : list) {
      if (n == target) return true;
    }
    return false;
  }

  public static boolean forAllPos(int[][] grid) {
    for (int r = 0; r < grid.length; r++) {
      System.out.println("Search row " + r);
      if (!allPos(grid[r])) return false;
    }
    return true;
  }

  public static boolean allPos(int[] list) {
    for (int n : list) {
      if (n <= 0) return false;
    }
    return true;
  }

}
