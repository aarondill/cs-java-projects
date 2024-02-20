import java.util.Scanner;

/**
 * Class Diya
 *
 * <pre>
 * Author1: Aaron Dill
 * Date:	March 28, 2023
 * </pre>
 *
 * Summary of file:
 * create a spiral
 *
 */
public class Diya {
    static Integer[][] matrix;
    static int sideLength;

    final private static void setupMatrix(int side) {
        matrix = new Integer[side][];
        sideLength = side;
        for (int i = 0; i < side; i++) {
            Integer[] row = new Integer[side];
            matrix[i] = row;
            for (int j = 0; j < side; j++)
                row[j] = -1;
        }
    }

    final private static boolean isValidInd(int x, int y) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[x].length;
    }

    final private static Integer getInd(int x, int y) {
        if (isValidInd(x, y))
            return matrix[x][y];
        else
            return null;
    }

    final private static Integer setInd(int x, int y, Integer value) {
        if (isValidInd(x, y))
            return matrix[x][y] = value;
        else
            return null;
    }

    final private static boolean isDefault(int x, int y) {
        Integer i = getInd(x, y);
        return i != null && i == -1;
    }

    private static void mapMatrix() {
        int incr = 0, x = -1, y = 0;
        // Y = vertical; x= horizontal
        // Stop if all other sides are already set
        while (isDefault(y + 1, x) || isDefault(y - 1, x) || isDefault(y, x + 1) || isDefault(y, x - 1)) {
            while (isDefault(y, ++x))
                setInd(y, x, ++incr);
            x--;
            while (isDefault(++y, x))
                setInd(y, x, ++incr);
            y--;
            while (isDefault(y, --x))
                setInd(y, x, ++incr);
            x++;
            while (isDefault(--y, x))
                setInd(y, x, ++incr);
            y++;
        }
    }

    /**
     * <p>
     * Copied exactly from {@link Integer#stringSize}
     * </p>
     * Returns the string representation size for a given int value.
     * 
     * @param x int value
     * @return string size
     * 
     * @see Integer#stringSize
     */
    static int stringSize(int x) {
        int d = 1;
        if (x >= 0) {
            d = 0;
            x = -x;
        }
        int p = -10;
        for (int i = 1; i < 10; i++) {
            if (x > p)
                return i + d;
            p = 10 * p;
        }
        return 10 + d;
    }

    private static void outputMatrix() {
        int matrixLength = matrix.length;
        int rowLength = matrix[0].length;
        int maxLen = stringSize(matrixLength * rowLength);

        for (Integer[] row : matrix) {
            for (Integer i : row)
                System.out.printf("%-" + maxLen + "d ", i);
            System.out.println();
        }
    }

    public static void main(String... args) {
        try (Scanner input = new Scanner(Diya.class.getResourceAsStream("./diya.dat"))) {
            while (input.hasNextInt()) {
                setupMatrix(input.nextInt());
                mapMatrix();
                outputMatrix();
                System.out.println("=====");
            }
        }
    }
}
