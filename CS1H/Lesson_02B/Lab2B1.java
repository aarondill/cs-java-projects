/**
 * Class Lab2B1
 *
 * <pre>
 * Author1:	Aaron Dill
 * Date:	January 30, 2023
 * Course:	Computer Science I Honors
 * Period:	4th
 * </pre>
 * 
 * Summary of file: Write a program to output the following, using four double constants and one
 * double variables, with printf formatting techniques to control the the number of decimal places
 * output for each value.
 * 
 * <pre>
 * `****.****.****.*
 *                 (9.200 - 8.450) + 0.290 * 27.000 = 8.580`
 * </pre>
 *
 */


class Lab2B1 {
    public static void main(String[] args) {
        final String INDENT = "";
        final int NUM1 = 3, NUM2 = 7, NUM3 = 6;
        int answer = NUM1 + NUM2 * NUM3;
        System.out.println("****.****.****.****.*");
        System.out.printf("%19s %d + %d * %d = %d\n", INDENT, NUM1, NUM2, NUM3, answer);
    }
}

