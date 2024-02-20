/**
 * Class Lab4A5
 *
 * <pre>
 * Author: Aaron Dill
 * Date:   April 26, 2023
 * Course: Computer Science I Honors
 * Period: 4th
 * </pre>
 *
 * Summary of file: Given the coordinates of two points on a graph, find and
 * output the slope of the line that passes through the two points. Also include
 * in the output a statement describing the line in general terms, like,
 * “Horizontal”, “Vertical”, “Ascending from left to right”, or “Descending from
 * left to right”. Keep in mind the slope of a line can be positive, negative,
 * undefined or zero. File input should be entered in the order x1, y1, x2, y2
 * for each pair of points. You may use any methods from the Math class in your
 * calculations. However, you must use a conditional statement to protect
 * against dividing by zero when the slope is undefined! Remember, first
 * determine if the slope is undefined, and if not, proceed with calculating the
 * slope.
 */
import static java.lang.System.err;
import static java.lang.System.out;
import java.io.InputStream;
import java.util.Scanner;

public class Lab4A5 {
    private static Double calculateSlope(double x1, double y1, double x2,
            double y2) {
        if (x1 == x2) {
            // Undefined slope
            return null;
        }
        double slope = (y2 - y1) / (x2 - x1);
        return slope;
    }

    public static void main(String[] args) {
        InputStream file = Lab4A5.class.getResourceAsStream("lab4A5.in");
        if (file == null) {
            err.println(
                    "Could not find your data file. Please ensure it's placed next to your compiled *.class file.");
            return;
        }

        // Input. this will close the scanner (and the input stream).
        try (Scanner scan = new Scanner(file)) {
            //Processing loop, contains input, process and output
            while (scan.hasNext()) {
                int x1 = scan.nextInt();
                int y1 = scan.nextInt();
                int x2 = scan.nextInt();
                int y2 = scan.nextInt();
                Double slope = calculateSlope(x1, y1, x2, y2);

                // Undefined slope
                if (slope == null)
                    out.printf(
                            "The slope of a line containing (%d,%d) and (%d,%d) is undefined.\n",
                            x1, y1, x2, y2);
                else
                    out.printf(
                            "The slope of a line containing (%d,%d) and (%d,%d) is %.3f.\n",
                            x1, y1, x2, y2, slope == -0d ? 0 : slope);

                if (slope == null)
                    out.println("The line is vertical.");
                else if (slope == 0)
                    out.println("The line is horizontal.");
                else if (slope > 0)
                    out.println("The line is ascending from left to right.");
                else
                    out.println("The line is descending from left to right.");
                // extra blank line
                out.println();
            }
        }

    }
}
