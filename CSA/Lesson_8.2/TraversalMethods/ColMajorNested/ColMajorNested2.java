/**
 * Primary java class: ColMajorNested2
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
public class ColMajorNested2 {
  public static void main(String... args) {
    int[][] grid = {{2, 6, 7, 4, 3, 2}, {9, 8, 5, 1, 8}, {4, 8, 2, 3, 5}, {2, 9, 5, 6, 4, 3}};
    int maxLen = 0;
    for (int[] row : grid)
      maxLen = Math.max(maxLen, row.length);
    for (int c = 0; c < maxLen; c++) {
      for (int r = 0; r < grid.length; r++) {
        if (c >= grid[r].length) continue;
        System.out.print("[" + r + "][" + c + "]=" + grid[r][c] + " ");
      }
      System.out.println();
    }
  }
}
