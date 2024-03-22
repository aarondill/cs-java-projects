/**
 * Primary java class: ColMajorNested
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
public class ColMajorNested {
  public static void main(String... args) throws InterruptedException {
    int[][] grid = {{2, 6, 7, 4, 3}, {9, 8, 5, 1, 8}, {4, 8, 2, 3, 5}, {2, 9, 5, 6, 4}};
    for (int c = 0; c < grid[0].length; c++) {
      for (int r = 0; r < grid.length; r++) {
        System.out.print("[" + r + "][" + c + "]=" + grid[r][c] + " ");
        // Thread.sleep(1000);
      }
      System.out.println();

    }
  }
}
