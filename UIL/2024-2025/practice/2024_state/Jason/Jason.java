import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Jason {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "jason.dat";

  // The constructor is called on each case
  private Jason(Scanner scan) {
    int aHeight = scan.nextInt();
    int aWidth = scan.nextInt();
    int bHeight = scan.nextInt();
    int bWidth = scan.nextInt();
    scan.nextLine();
    int[][] a = new int[aHeight][aWidth];
    for (int y = 0; y < aHeight; y++) {
      for (int x = 0; x < aWidth; x++) {
        a[y][x] = scan.nextInt();
      }
      scan.nextLine();
    }

    int[][] b = new int[bHeight][bWidth];
    for (int y = 0; y < bHeight; y++) {
      for (int x = 0; x < bWidth; x++) {
        b[y][x] = scan.nextInt();
      }
      scan.nextLine();
    }
    int[][] c = multiply(a, b);
    if (c == null) System.out.println(caseNum + ":MATRIX SIZES NOT COMPATIBLE");
    else {
      System.out.println(caseNum + ":" + c.length + "x" + c[0].length);
      for (int y = 0; y < c.length; y++) {
        for (int x = 0; x < c[0].length; x++) {
          System.out.printf("%7d", c[y][x]);
        }
        System.out.println();
      }
    }
    System.out.println("^^^^^^^^^^^^^^^");
  }
  /// matrix A with n rows and m columns and matrix B with m rows and p columns
  /// The number of columns m in A must equal the number of rows m in B.
  /// The result matrix C will have n rows and p columns.
  private int[][] multiply(int[][] a, int[][] b) {
    int n = a.length, m = a[0].length, p = b[0].length;
    if (m != b.length) return null; // matrix sizes not compatible
    int[][] res = new int[n][p];
    for (int i = 0; i < res.length; i++) {
      for (int j = 0; j < res[0].length; j++) {
        // Position (i,j) in the result matrix C is the sum of m products, the elements in row i of A multiplied by the elements in column j of B.
        for (int k = 0; k < m; k++) {
          res[i][j] += a[i][k] * b[k][j];
        }
      }
    }

    return res;
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        new Jason(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
