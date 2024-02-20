import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Class Alan
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
 * Summary of file: Each line of output must consist of “F degrees Fahrenheit is
 * equal to K Kelvin”,
 * where F is the input temperature in degrees Fahrenheit, and K is the
 * converted temperature in
 * Kelvin using the formula above. Output should be formatted to two decimal
 * places after the
 * decimal point.
 *
 */
class Alan {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream datPath = Alan.class.getResourceAsStream("./alan.dat");
        Scanner dataScanner = new Scanner(datPath);
        int dataCount = dataScanner.nextInt();
        dataScanner.nextLine();
        for (int i = 0; i < dataCount; i++) {
            int fahrenheit = Integer.parseInt(dataScanner.nextLine());
            double k = (5.0 / 9.0) * (fahrenheit - 32) + 273.15;
            System.out.printf("%d degrees Fahrenheit is equal to %.2f Kelvin\n", fahrenheit, k);
        }
        dataScanner.close();
    }
}
