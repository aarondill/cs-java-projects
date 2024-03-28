import java.util.Objects;

/**
 * The class Traversals contains methods for traversing 2D Arrays such row major
 * and column major along with other helpful methods.
 *
 * @author Aaron Dill (nonya@example.com)
 */
public class Traversals {
  /** NO */
  private Traversals() {
    throw new RuntimeException("No instance for you!");
  }

  /**
   * A utility method to print each element with 4 spaces columns
   *
   * @param x Recieves a String element
   */
  private static void output(String x) {
    System.out.printf("%4s", x);
  }

  /**
   * This method receives a 2D Array then outputs the 2D Array in row-major order
   * using enhanced for loops.
   *
   * @param grid Receives a 2D Array
   */
  public static void rowMajorTraversalNested(int[][] grid) {
    if (grid == null) return;
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++)
        output(grid[r][c] + " ");
      System.out.println();

    }
  }

  /**
   * This method receives a 2D Array then outputs the 2D Array in column-major
   * order using nested for loops.
   *
   * @param grid Receives a 2D Array
   */
  public static void colMajorTraversalNested(int[][] grid) {
    if (grid == null) return;
    for (int c = 0; c < grid[0].length; c++) {
      for (int r = 0; r < grid.length; r++)
        output(grid[r][c] + " ");
      System.out.println();
    }
  }

  /**
   * This method receives a 2D Array then outputs the 2D Array in row-major order
   * using enhanced for loops.
   *
   * @param grid Receives a 2D Array
   */
  public static void rowMajorTraversalForEach(int[][] grid) {
    if (grid == null) return;
    for (int[] row : grid) {
      for (int x : row)
        output(x + " ");
      System.out.println();
    }
  }

  /**
   * This method receives a 2D Array then returns the sum of the given row
   *
   * @param grid Receives a 2D Array
   * @param row Receives the row number
   * @return the sum of the row
   */
  public static int sumRow(int[][] grid, int row) {
    if (grid == null) return -999;
    if (row < 0 || row >= grid.length) return -999;
    int sum = 0;
    for (int c = 0; c < grid[row].length; c++)
      sum += grid[row][c];
    return sum;
  }

  /**
   * This method receives a 2D Array then returns the average of the given column
   *
   * @param grid Receives a 2D Array
   * @param col Receives the column number
   * @return the average of the column
   */
  public static double colAvg(int[][] grid, int col) {
    Objects.requireNonNull(grid);
    double sum = 0, count = 0;
    for (int r = 0; r < grid.length; r++) {
      sum += grid[r][col];
      count++;
    }
    return sum / count;
  }

  /**
   * This method receives a 2D Array then returns the minimum element
   *
   * @param grid Receives a 2D Array
   * @return the minimum element
   */
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

  /**
   * This method receives a 2D Array then returns whether the given target exists
   * in the array
   *
   * @param grid Receives a 2D Array
   * @param target Receives the target
   * @return whether the given target exists in the array
   */
  public static boolean thereExists(int[][] grid, int target) {
    for (int r = 0; r < grid.length; r++) {
      System.out.println("Search row " + r);
      if (search(grid[r], target)) return true;
    }
    System.out.println("Target was not found");
    return false;
  }

  /**
   * This mehtod receives an array and returns whether the given target exists in
   * the array
   *
   * @param list Receives an array
   * @param target Receives the target
   * @return whether the given target exists in the array
   */
  public static boolean search(int[] list, int target) {
    for (int n : list) {
      if (n == target) return true;
    }
    return false;
  }

  /**
   * This method receives a 2D Array then whether returns all the elements are
   * positive
   *
   * @param grid Receives a 2D Array
   * @return whether all the elements are positive
   */
  public static boolean forAllPos(int[][] grid) {
    for (int r = 0; r < grid.length; r++) {
      System.out.println("Search row " + r);
      if (!allPos(grid[r])) return false;
    }
    return true;
  }

  /**
   * This method takes a list and returns whether all the elements are positive
   *
   * @param list Receives an array
   * @return whether all the elements are positive
   */
  public static boolean allPos(int[] list) {
    for (int n : list) {
      if (n <= 0) return false;
    }
    return true;
  }

  /**
   * This method takes a list and returns whether all the elements are even
   *
   * @param list Receives an array
   * @return whether all the elements are even
   */
  public static boolean allEven(int[] list) {
    for (int x : list) {
      if (x % 2 != 0) return false;
    }
    return true;
  }

  /**
   * This method takes a list and returns the maximum element
   *
   * @param grid Receives an array
   * @return the maximum element
   */
  public static int maxGrid(int[][] grid) {
    if (grid == null) return -999;
    if (grid.length == 0 || grid[0].length == 0) return -999;
    int max = grid[0][0];
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++) {
        if (grid[r][c] > max) max = grid[r][c];
      }
    }
    return max;
  }

  /**
   * This method takes a list and outputs whether all elements are even
   *
   * @param grid Receives an array
   */
  public static void forAllEven(int[][] grid) {
    System.out.println("Check for all even elements");
    for (int r = 0; r < grid.length; r++) {
      System.out.println("Search row " + r);
      if (!allEven(grid[r])) {
        System.out.println("At least one element is odd");
        return;
      }
    }
    System.out.println("All elements are even");

  }

  /**
   * This method takes a list and returns the average of the given row
   *
   * @param grid Receives an array
   * @param row Receives the row number
   * @return the average of the row
   */
  public static double rowAvg(int[][] grid, int row) {
    Objects.requireNonNull(grid);
    double sum = 0, count = 0;
    for (int c = 0; c < grid[row].length; c++) {
      sum += grid[row][c];
      count++;
    }
    return sum / count;
  }

  /**
   * This method receives a 2D Array then returns the sum of the given column
   *
   * @param grid Receives a 2D Array
   * @param col Receives the column number
   * @return the sum of the column
   */
  public static int sumCol(int[][] grid, int col) {
    if (grid == null) return -999;
    if (col < 0 || col >= grid.length) return -999;
    int sum = 0;
    for (int r = 0; r < grid.length; r++)
      sum += grid[r][col];
    return sum;
  }
}
