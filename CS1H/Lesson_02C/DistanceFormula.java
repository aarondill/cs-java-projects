/**
 * Class DistanceFormula
 *
 * <pre>
 * Author:	Aaron Dill
 * Date:	February 15, 2023
 * Course:	Computer Science I Honors
 * Period:	4th
 * </pre>
 *
 * Summary of file:
 *
 * Implement the distance formula program example shown earlier in the lesson, using the points
 * (2,3) and (5,7).
 * 
 */
import static java.lang.Math.*;

class DistanceFormula {
    public static void main(String[] args) {
        int x1 = 2, y1 = 3, x2 = 5, y2 = 7;
        double dist = sqrt(pow(y2 - y1, 2) + pow(x2 - x1, 2));
        System.out.println("The distance between the points");
        System.out.printf("(%d,%d) and (%d,%d) is %.1f\n", x1, y1, x2, y2, dist);
        x1 = 1;
        y1 = 3;
        x2 = -3;
        y2 = -4;
        System.out.println();
        dist = sqrt(pow(y2 - y1, 2) + pow(x2 - x1, 2));
        System.out.println("The distance between the points");
        System.out.printf("(%d,%d) and (%d,%d) is %.1f\n", x1, y1, x2, y2, dist);
    }
}
