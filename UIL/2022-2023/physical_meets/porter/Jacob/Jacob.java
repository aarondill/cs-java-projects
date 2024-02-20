import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class Jacob
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Author3: Evan Sao
 * Date:	February 11, 2023
 * </pre>
 *
 * Summary of file: output an approximation of PI
 *
 */
class Jacob {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner dataScanner = new Scanner(new File("./jacob.dat"));
        int dataCount = dataScanner.nextInt();
        dataScanner.nextLine();
        for (int i = 0; i < dataCount; i++) {
            double pi = 3;
            boolean add = true;
            double A = 2, B = 3, C = 4;
            for (int t = dataScanner.nextInt(); t > 0; t--) {
                if (add) {
                    pi += 4 / (A * B * C);
                } else {
                    pi -= 4 / (A * B * C);
                }
                A += 2;
                B += 2;
                C += 2;
                add = !add;
            }
            System.out.printf("%.13f\n", pi);
        }
    }
}
