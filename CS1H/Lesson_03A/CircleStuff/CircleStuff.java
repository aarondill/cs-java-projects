package CircleStuff;

import java.util.Scanner;

/**
 * Class CircleStuff
 *
 * <pre>
 * Author:	Aaron Dill
 * Date:	March 27, 2023
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
public class CircleStuff {
    private static double rad1, rad2, area1, area2, circ1, circ2;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        // Input section
        System.out.print("Enter a radius-->");
        rad1 = kb.nextDouble();
        System.out.print("Enter another radius-->");
        rad2 = kb.nextDouble();
        kb.close();
        // Process Section
        area1 = Math.pow(rad1, 2) * Math.PI;
        circ1 = rad1 * 2 * Math.PI;
        area2 = Math.pow(rad2, 2) * Math.PI;
        circ2 = rad2 * 2 * Math.PI;
        // Output section
        System.out.println();
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
