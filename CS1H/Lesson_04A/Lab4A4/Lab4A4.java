/**
 * Class Lab4A4
 *
 * <pre>
 * Author: Aaron Dill
 * Date:   April 26, 2023
 * Course: Computer Science I Honors
 * Period: 4th
 * </pre>
 *
 * Summary of file: WAP to accept as input a NAME and a NUMERICAL GRADE. Output
 * the input values in a complete sentence. Also, output a congratulatory
 * message if the grade is an A or a word of encouragement if the grade is an F.
 * No special message is to be output for any other grade letter.
 */
import static java.lang.System.err;
import static java.lang.System.out;
import java.io.InputStream;
import java.util.Scanner;

public class Lab4A4 {
    public static void main(String[] args) {
        InputStream file = Lab4A4.class.getResourceAsStream("lab4A4.in");
        if (file == null) {
            err.println(
                    "Could not find your data file. Please ensure it's placed next to your compiled *.class file.");
            return;
        }

        // Input. this will close the scanner (and the input stream).
        try (Scanner scan = new Scanner(file)) {
            //Processing loop, contains input, process and output
            while (scan.hasNext()) {
                String name = scan.next();
                int grade = scan.nextInt();
                out.printf("%s, you made a grade of %d. ", name, grade);
                if (grade >= 90) {
                    out.println("Congratulations!");
                } else if (grade <= 70) {
                    out.println("Study more next time.");
                } else
                    out.println();
            }
        }

    }
}
