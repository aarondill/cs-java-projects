/**
 * Class SquareArea
 *
 * <pre>
 * Author:	Aaron Dill
 * Date:	February 15, 2023
 * Course:	Computer Science I Honors
 * Period:	4th
 * </pre>
 *
 * Summary of file: Write a program to calculate the side of a square given the area.
 */
class SquareArea {
    public static void main(String[] args) {
        final String HEADER = "****.*";
        int area = 144;
        System.out.println(HEADER);
        double side = Math.sqrt(area);
        System.out.printf("%5sThe side length of a square with an area of %d is %.2f\n", "", area,
                side);
        area = 200;
        System.out.println();
        System.out.println(HEADER);
        side = Math.sqrt(area);
        System.out.printf("%5sThe side length of a square with an area of %d is %.2f\n", "", area,
                side);

    }
}
/**
 * Use the Math.sqrt method in your calculation and assign the answer to a variable called side.
 * Output the answer to two decimal places. No literal values should appear in the output statement,
 * only variables. Do a second output with the value of area as 200, recalculating the side length.
 * Indent 5 spaces. Note: Your output MUST match the output shown below.
 */
