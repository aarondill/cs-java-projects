import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class Marek
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Author3: Daniel Behringer
 * Author4: Christian Adusei
 * Date:	February 08, 2023
 * </pre>
 *
 * Summary of file:
 * 
 * Create a program to output the result of an infix operation using the
 * operations +, -, *, /< (,
 * and ). Division by zero equals "Infinity"
 *
 */

class Marek {
    public static String calculateExpression(String expression) {
        throw new java.lang.UnsupportedOperationException("Not implemented yet.");
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner dataScanner = new Scanner(new File("./marek.dat"));
        int dataCount = dataScanner.nextInt();
        dataScanner.nextLine();
        for (int i = 0; i < dataCount; i++) {
            String expression = dataScanner.nextLine();
            System.out.println(calculateExpression(expression));
        }
    }
}
