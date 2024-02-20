/**
 * Class Lab2B3
 *
 * <pre>
 * Author1:	Aaron Dill
 * Date:	January 30, 2023
 * Course:	Computer Science I Honors
 * Period:	4th
 * </pre>
 * 
 * Summary of file: Write a program to output the following, using constants, a variable, and printf
 * formatting techniques.
 * 
 * <pre>
 * ****.****.****.*
 *                3 + 7 + 6 = 45
 * </pre>
 *
 */

class Lab2B3 {
    public static void main(String[] args) {
        final String INDENT = "";
        final double DOUBLE1 = 9.2, DOUBLE2 = 8.45, DOUBLE3 = 0.29, DOUBLE4 = 27.0;
        double answer = (DOUBLE1 - DOUBLE2) + DOUBLE3 * DOUBLE4;
        System.out.println("****.****.****.*");
        System.out.printf("%15s(%.3f - %.3f) + %.3f * %.3f = %.3f\n", INDENT, DOUBLE1, DOUBLE2,
                DOUBLE3, DOUBLE4, answer);
    }
}
