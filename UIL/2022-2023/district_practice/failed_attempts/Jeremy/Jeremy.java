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

    public interface matrixMapper {
        Integer run(int x, int y, int compX, int compY, int newVal, int oldVal, int compVal);
    }

    private static void mapMatrix(matrixMapper func, int compX, int compY, int newVal) {
        for (int i = 0; i < matrix.length; i++) {
            Integer[] row = matrix[i];
            int compVal = matrix[compX][compY];
            for (int j = 0; j < row.length; j++) {
                row[j] = func.run(j, i, compX, compY, newVal, row[j], compVal);
            }
        }
    }

    private static void getMatrix(int R, int C, Scanner scan) {
        matrix = new Integer[R][C];
        for (int i = 0; i < R; i++) {
            Integer[] row = new Integer[C];
            for (int j = 0; j < C; j++) {
                row[j] = scan.nextInt();
            }
            matrix[i] = row;
        }
    }

    private static void outputMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            Integer[] row = matrix[i];
            List<String> rowString = Arrays.stream(row).map(n -> n.toString()).toList();
            System.out.println(String.join(" ", rowString));
        }
    }

    private static Integer mapperFunc(int x, int y, int compX, int compY, int newVal, int oldVal, int compVal) {
        if (Math.abs(x - compX) > 1 || Math.abs(y - compY) > 1 || oldVal != compVal)
            return oldVal;
        return newVal;
    }

    private static int changeMatrixRecursively(int startX, int startY, Integer newVal) {
        int t = matrix[startX][startY];
        matrix[startX][startY] = newVal;
        mapMatrix(Jeremy::mapperFunc, startX, startY, newVal);
        return t;
    }

    public static void main(String[] args) {
        int dataCount = dataScanner.nextInt();
        for (int i = 0; i < dataCount; i++) {
            int R = dataScanner.nextInt();
            int C = dataScanner.nextInt();

            getMatrix(R, C, dataScanner);

            int A = dataScanner.nextInt();
            int B = dataScanner.nextInt();
            int D = dataScanner.nextInt();

            outputMatrix();
            System.out.println("=====");
            changeMatrixRecursively(A, B, D);
            outputMatrix();

            System.out.printf("Change: (%d, %d) to %d\n", A, B, D);
            System.out.println("=====");
        }
        dataScanner.close();
    }
}
