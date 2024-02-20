/**
 * Class CircleArea
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
 * Write a program to output the area of a circle with a radius of 1.7.
 */
class CircleArea {
    public static void main(String[] args) {
        double radius = 1.7;
        double area = Math.pow(radius, 2) * Math.PI;
        final String HEADER = "****.****.****.****.*";
        System.out.println(HEADER);
        System.out.printf("%15s%.4f * %.4f * %.4f = %.4f\n", "", radius, radius, Math.PI, area);

        System.out.println();
        radius = 10.25;
        area = Math.pow(radius, 2) * Math.PI;
        System.out.println(HEADER);
        System.out.printf("%15s%.4f * %.4f * %.4f = %.4f\n", "", radius, radius, Math.PI, area);
    }
}
