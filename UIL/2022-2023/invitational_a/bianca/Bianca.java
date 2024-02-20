import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class Bianca
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Author3: Daniel Behringer
 * Author4: Christian Adusei 
 * Date:	February 01, 2023
 * Course:	N/A
 * </pre>
 * 
 * Summary of file: Output the value of C (0 < C < 1000000) given the A and B
 * values from the input,
 * rounded to 2 decimal places, as shown below.
 *
 */
class Bianca {
    public static double pythagoreanTheorem(int a, int b) {
        return Math.pow(a, 2) + Math.pow(b, 2);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileInput = new Scanner(new File("./bianca.dat"));
        int dataCount = fileInput.nextInt();
        for (int i = 0; i < dataCount; i++) {
            int a = fileInput.nextInt();
            int b = fileInput.nextInt();
            double cSquared = pythagoreanTheorem(a, b);
            System.out.printf("%.2f\n", Math.sqrt(cSquared));
        }
    }
}
