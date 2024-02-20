import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Class Jeremy
 *
 * <pre>
 * Author1: Aaron Dill
 * Date:	March 24, 2023
 * </pre>
 *
 * Summary of file:
 * do a flood fill on a matrix of numbers
 *
 */
public class Jeremy {
    private static Integer[][] matrix;
    private static Scanner dataScanner = new Scanner(Jeremy.class.getResourceAsStream("./jeremy.dat"));

    // Gets the matrix from inputs R, C, and the scanner
    private static void setupMatrix(int R, int C) {
        matrix = new Integer[R][C];
        for (int i = 0; i < R; i++) {
            Integer[] row = new Integer[C];
            for (int j = 0; j < C; j++) {
                row[j] = dataScanner.nextInt();
            }
            matrix[i] = row;
        }
    }

    // Outputs the matrix separated by spaces using String.join(" ", ...);
    private static void outputMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            Integer[] row = matrix[i];
            List<String> rowString = Arrays.stream(row).map(n -> n.toString()).toList();
            System.out.println(String.join(" ", rowString));
        }
    }

    // Returns whether the specified x and y can be used to index the matrix
    private static boolean isValidIndex(int x, int y) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[x].length;
    }

    // Returns the value at the specified index or null if the index is out of
    // bounds
    private static Integer getVal(int x, int y) {
        if (isValidIndex(x, y))
            return matrix[x][y];
        else
            return null;
    }

    // Sets the value at the specified index if possible. Nothing happens if the
    // index is out of bounds.
    private static void setVal(int x, int y, int v) {
        if (isValidIndex(x, y))
            matrix[x][y] = v;
    }

    // Recursive implementation of a flood fill on a matrix given X, Y, and the
    // value to set
    private static void MatrixRecursiveFloodFill(int x, int y, Integer val) {
        Integer t = getVal(x, y);
        setVal(x, y, val);
        if (t == null)
            return;
        if (getVal(x + 1, y) == t)
            MatrixRecursiveFloodFill(x + 1, y, val);
        if (getVal(x - 1, y) == t)
            MatrixRecursiveFloodFill(x - 1, y, val);
        if (getVal(x, y + 1) == t)
            MatrixRecursiveFloodFill(x, y + 1, val);
        if (getVal(x, y - 1) == t)
            MatrixRecursiveFloodFill(x, y - 1, val);
        return;
    }

    // Main.
    public static void main(String[] args) {
        int dataCount = dataScanner.nextInt();
        for (int i = 0; i < dataCount; i++) {
            int R = dataScanner.nextInt();
            int C = dataScanner.nextInt();
            setupMatrix(R, C);
            int A = dataScanner.nextInt();
            int B = dataScanner.nextInt();
            int D = dataScanner.nextInt();
            MatrixRecursiveFloodFill(A, B, D);
            outputMatrix();
            System.out.println("=====");
        }
        dataScanner.close();
    }
}
