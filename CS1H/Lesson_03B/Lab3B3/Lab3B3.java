import java.util.Scanner;
import java.io.*;

/**
 * Class Lab3B3
 *
 * <pre>
 * Author:	Aaron Dill
 * Date:	April 12, 2023
 * Course:	Computer Science I Honors
 * Period:	4th
 * </pre>
 *
 * Summary of file: input the radius values of two circles into double variables
 * {@link #rad1} and {@link #rad2}. Calculate and assign to the variables
 * {@link #area1}, {@link #area2}, {@link #circ1}, and {@link #circ2}, the area
 * and circumference of each circle. Use {@link Math#PI} in your calculations.
 * Be sure to label and format each output value properly as shown below. Align
 * the "=" signs in column 24. Remember to label all sections and close the
 * input object.
 */
public class Lab3B3 {
    private static double rad1, rad2, area1, area2, circ1, circ2;

    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("lab3b3.in"));
        // Input section
        rad1 = file.nextDouble();
        rad2 = file.nextDouble();
        file.close();
        // Process Section
        area1 = Math.pow(rad1, 2) * Math.PI;
        circ1 = rad1 * 2 * Math.PI;
        area2 = Math.pow(rad2, 2) * Math.PI;
        circ2 = rad2 * 2 * Math.PI;
        // Output section
        System.out.println("****.****.****.****.****");
        System.out.printf("%24s %.1f\n", "Radius =", rad1);
        System.out.printf("%24s %.1f\n", "Area =", area1);
        System.out.printf("%24s %.1f\n", "Circumference =", circ1);
        System.out.println("****.****.****.****.****");
        System.out.printf("%24s %.1f\n", "Radius =", rad2);
        System.out.printf("%24s %.1f\n", "Area =", area2);
        System.out.printf("%24s %.1f\n", "Circumference =", circ2);

    }
}
