import java.io.File;
import java.io.FileNotFoundException;
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
    public static double fahrenheitToKelvin(int fahrenheit) {
        return (5.0 / 9) * (fahrenheit - 32) + 273.15;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner inputFile = new Scanner(new File("./alan.dat"));
        while (inputFile.hasNextInt()) {
            int fahrenheit = inputFile.nextInt();
            double kelvin = fahrenheitToKelvin(fahrenheit);
            System.out.printf("%d degrees Fahrenheit is equal to %.2f Kelvin\n", fahrenheit,
                    kelvin);
        }
        inputFile.close();
    }
}
