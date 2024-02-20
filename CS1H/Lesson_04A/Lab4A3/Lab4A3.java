/**
 * Class Lab4A3
 *
 * <pre>
 * Author: Aaron Dill
 * Date:   April 26, 2023
 * Course: Computer Science I Honors
 * Period: 4th
 * </pre>
 *
 * Summary of file: A phone call to Lubbock, Texas of up to five-minutes long
 * using a land line costs $2.45. Each additional minute costs 65 cents. WAP to
 * accept an input INTEGER for the length of the call in minutes and output the
 * cost.
 */
import static java.lang.System.err;
import static java.lang.System.out;
import java.io.InputStream;
import java.util.Scanner;

public class Lab4A3 {
    public static void main(String[] args) {
        InputStream file = Lab4A3.class.getResourceAsStream("lab4A3.in");
        if (file == null) {
            err.println(
                    "Could not find your data file. Please ensure it's placed next to your compiled *.class file.");
            return;
        }

        // Input. this will close the scanner (and the input stream).
        try (Scanner scan = new Scanner(file)) {
            //Processing loop, contains input, process and output
            while (scan.hasNext()) {
                int minutes = scan.nextInt();
                double cost = 2.45;
                if (minutes > 5) {
                    cost += .65 * (minutes - 5);
                }
                out.printf(
                        "A %d minute phone call to Lubbock, TX costs $%.2f.\n",
                        minutes, cost);
            }
        }

    }
}
