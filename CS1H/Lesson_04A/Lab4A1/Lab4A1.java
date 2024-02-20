/**
 * Class Lab4A1
 *
 * <pre>
 * Author: Aaron Dill
 * Date:   April 26, 2023
 * Course: Computer Science I Honors
 * Period: 4th
 * </pre>
 *
 * Summary of file: WAP to input someone's age and output three statements that
 * report whether that person can vote, drive, or legally consume alcoholic
 * beverages.
 */
import static java.lang.System.err;
import static java.lang.System.out;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab4A1 {

    public static void main(String[] args) {
        ArrayList<Integer> ages = new ArrayList<>();
        InputStream file = Lab4A1.class.getResourceAsStream("./lab4A1.in");
        if (file == null) {
            err.println(
                    "Could not find your data file. Please ensure it's placed next to your compiled *.class file.");
            return;
        }

        // Input. this will close the scanner (and the input stream).
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNext())
                ages.add(scan.nextInt());
        }
        // processing and output
        for (int age : ages) {
            out.println("****.**");
            // drive
            out.print("At age " + age + " a person is ");
            if (age <= 16)
                out.print("not ");
            out.println("old enough to drive.");

            // vote
            out.print("At age " + age + " a person is ");
            if (age <= 18)
                out.print("not ");
            out.println("old enough to vote.");

            // drink alcohol legally
            out.print("At age " + age + " a person is ");
            if (age <= 21)
                out.print("not ");
            out.println("old enough to drink alcohol legally.");

        }
    }
}
