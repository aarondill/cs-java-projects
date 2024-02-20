package CircleStuff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

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
public class CircleStuff_Improved {
    public static <T> T getInput(String prompt, Supplier<T> getData) {
        System.out.print(prompt);
        return getData.get();
    }

    private static double getArea(double radius) {
        return Math.pow(radius, 2) * Math.PI;
    }

    private static double getCircumference(double radius) {
        return radius * 2 * Math.PI;
    }

    public static void main(String[] args) {
        List<Double> radii = new ArrayList<>();
        final int ITERATIONS = 2;
        // Input section
        try (Scanner kb = new Scanner(System.in)) {
            for (int i = 0; i < ITERATIONS; i++) {
                radii.add(getInput("Enter a radius-->", kb::nextDouble));
            }
        }
        // Process Section
        List<Double> areaList =
                radii.stream().map(CircleStuff_Improved::getArea).toList();
        List<Double> circList = radii.stream()
                .map(CircleStuff_Improved::getCircumference).toList();

        // Output section
        System.out.println();
        for (int i = 0; i < radii.size(); i++) {
            System.out.println("****.****.****.****.****");
            System.out.printf("%24s %.1f\n", "Radius =", radii.get(i));
            System.out.printf("%24s %.1f\n", "Area =", areaList.get(i));
            System.out.printf("%24s %.1f\n", "Circumference =",
                    circList.get(i));
        }

    }
}
