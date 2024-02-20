/**
 * Class Lab4A2
 *
 * <pre>
 * Author: Aaron Dill
 * Date:   April 26, 2023
 * Course: Computer Science I Honors
 * Period: 4th
 * </pre>
 *
 * Summary of file: WAP to input two integers, and first determine the larger
 * and smaller value. Divide the larger by the smaller, and output the quotient
 * and remainder. However, NO REMAINDER IS TO BE PRINTED if its value is zero.
 */
import static java.lang.System.err;
import static java.lang.System.out;
import java.io.InputStream;
import java.util.Scanner;

public class Lab4A2 {
    public static void main(String[] args) {
        InputStream file = Lab4A2.class.getResourceAsStream("lab4A2.in");
        if (file == null) {
            err.println(
                    "Could not find your data file. Please ensure it's placed next to your compiled *.class file.");
            return;
        }

        // Input. this will close the scanner (and the input stream).
        try (Scanner scan = new Scanner(file)) {
            //Processing loop, contains input, process and output
            while (scan.hasNext()) {
                int num1 = scan.nextInt();
                int num2 = scan.nextInt();
                int larger = Math.max(num1, num2);
                int smaller = Math.min(num1, num2);;

                int answer = larger / smaller;
                int remainder = larger % smaller;
                out.printf("%d divided by %d equals %d", larger, smaller,
                        answer);
                if (remainder > 0)
                    out.printf(" remainder %d", remainder);
                out.println();
            }
        }

    }
}
