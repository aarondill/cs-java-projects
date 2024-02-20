import java.util.Arrays;
import java.util.Scanner;

/**
 * Primary java class: Mia
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
public class Mia {
  //   Output: For each case you are to output either: “Matrix X: Identity Matrix - No swaps needed” if the
  // original matrix was an identity matrix in its original form (ie, no swaps were needed), “Matrix X: Identity Matrix -
  // Swaps needed” if the original matrix could be transformed into an identity matrix with the use of swaps, or “Matrix X:
  // This is not an Identity Matrix” if the matrix can not be transformed into an identity matrix, no matter the
  // combination of swaps used.
  private static String ident(int[][] matrix) {
    for (int[] row : matrix) {
      long onesCount = Arrays.stream(row).filter(x -> x == 1).count();
      if (onesCount == 0 || onesCount > 1) return "This is not an Identity Matrix";
    }
    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][i] != 1) return "Identity Matrix - Swaps needed";
    }
    return "Identity Matrix - No swaps needed";
  }

  public static void main(String... args) {
    //     Input: Input will begin with a number N, the number of test cases. N will be in the range of [1,15]. Each test case will begin
    // with a single integer D, the dimension of the square matrix. D will be in the range of [1,25]. The following D lines will each
    // contain D numbers. The numbers will either be a 0 or a 1, separated by a space. This represents the matrix to be evaluated for the
    // given case.
    try (Scanner scan = new Scanner(Mia.class.getResourceAsStream("./mia.dat"))) {
      int testCases = scan.nextInt();
      for (int i = 0; i < testCases; i++) {
        int dimension = scan.nextInt();
        int[][] matrix = new int[dimension][dimension];
        for (int y = 0; y < dimension; y++) {
          for (int x = 0; x < dimension; x++) {
            matrix[x][y] = scan.nextInt();
          }
        }
        System.out.println(String.format("Matrix %d: %s", i + 1, ident(matrix)));
      }

    }
  }
}
