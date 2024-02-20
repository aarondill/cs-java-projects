import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.function.Supplier;

/**
 * Class Lab3B8
 *
 * <pre>
 * Author:	Aaron Dill
 * Date:	April 14, 2023
 * Course:	Computer Science I Honors
 * Period:	4th
 * </pre>
 *
 * Summary of file: WAP to input the radius of a sphere, and then calculate and
 * output the surface area and volume of that sphere. Make your program accept
 * two input values and produce two outputs. Find the formulas for surface area
 * and volume of a sphere in a math textbook or on the internet.
 */
public class Lab3B8 {
    // Prompt is ignored
    private static <T> T getData(String prompt, Supplier<T> cb) {
        return cb.get();
    }

    public static void main(String[] args) throws IOException {
        final int ITERATIONS = 2;
        // This closes the scanner when it's done with it.
        try (Scanner kb = new Scanner(new File("./lab3B8.in"));) {
            for (int i = 0; i < ITERATIONS; i++) {
                double rad;
                double surfArea, vol;
                //Input section
                rad = getData("Enter a radius...", kb::nextDouble);
                //Process Section
                surfArea = 4 * Math.PI * Math.pow(rad, 2);
                vol = 4.0 / 3 * Math.PI * Math.pow(rad, 3);
                //Output section
                System.out.println("****.");
                System.out.printf(
                        "The surface area of a sphere with radius %.2f is %.2f.\n",
                        rad, surfArea);
                System.out.printf(
                        "The volume of a sphere with radius %.2f is %.2f.\n",
                        rad, vol);
            }
        }
    }
}
