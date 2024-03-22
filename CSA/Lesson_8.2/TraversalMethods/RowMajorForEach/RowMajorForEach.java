/**
 * Primary java class: RowMajorForEach
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
public class RowMajorForEach {
  public static void main(String... args) {
    int[][] grid = {{2, 6, 7, 4, 3}, {9, 8, 5, 1, 8}, {4, 8, 2, 3, 5}, {2, 9, 5, 6, 4}};
    rowMajorTraversalForEach(grid);

  }

  public static void rowMajorTraversalForEach(int[][] g) {
    for (int[] row : g) {
      for (int x : row)
        System.out.print(x + " ");
      System.out.println();
    }
  }
}
