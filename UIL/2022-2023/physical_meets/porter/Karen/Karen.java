import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class Karen
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Author3: Evan Sao
 * Date:	February 11, 2023
 * </pre>
 *
 * Summary of file: represent close int perfect square to input
 */

class Karen {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner dataScanner = new Scanner(new File("./karen.dat"));

        int dataCount = dataScanner.nextInt();
        dataScanner.nextLine();
        for (int i = 0; i < dataCount; i++) {
            double num = dataScanner.nextInt();
            num = Math.sqrt(num);
            num = Math.round(num);
            num = Math.pow(num, 2);
            System.out.printf("%.0f\n", num);
        }
    }
}
