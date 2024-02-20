import java.util.Scanner;

/**
 * Primary java class: Renata
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/02/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Renata {
  public static void main(String... args) {
    //     Input: The first line is a positive integer T ≤ 10, the number of test cases in the data file. That will then be followed by T sets
    // of data. For each set, the first line will contain 1 integer (N) the number of rows and columns in the scoring grid, with 5 ≤ N ≤
    // 15. The dataset continues with N rows, each containing N integers (S) to populate the scoring grid with 0 ≤ S ≤ 15. The next
    // line will be the number of positions recorded. Each position appears on a separate line as two integers, the row and column
    // position of the grid.
    try (Scanner scan = new Scanner(Renata.class.getResourceAsStream("./renata.dat"))) {
      int T = scan.nextInt();
      for (int i = 0; i < T; i++) {
        int N = scan.nextInt();
        int[][] grid = new int[N][N];
        for (int j = 0; j < N; j++) {
          for (int k = 0; k < N; k++) {
            grid[j][k] = scan.nextInt();
          }
        }
        int positions = scan.nextInt();

        int score = 0;
        for (int j = 0; j < positions; j++) {
          int row = scan.nextInt() - 1; // one indexed
          int col = scan.nextInt() - 1; // one indexed
          score += grid[row][col];
        }
        System.out.println(i + 1 + ": " + score);
      }

    }
  }
}
