import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class Shivani
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Author3: Evan Sao
 * Date:	February 11, 2023
 * </pre>
 *
 * Summary of file:
 * 
 * number of spheres needed to form a triangle pyramid of N layers
 *
 */
class Shivani {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner dataScanner = new Scanner(new File("./shivani.dat"));
        int dataCount = dataScanner.nextInt();
        dataScanner.nextLine();
        for (int i = 0; i < dataCount; i++) {
            double total = 0;
            double layers = dataScanner.nextDouble();
            double prev = 0;
            for (double layer = 1; layer <= layers; layer++) {
                total += prev + layer;
                prev += layer;
            }
            System.out.printf("%.0f\n", total);
        }
    }
}
