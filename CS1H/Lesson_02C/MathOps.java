/**
 * Class MathOps
 *
 * <pre>
 * Author:	Aaron Dill
 * Date:	February 15, 2023
 * Course:	Computer Science I Honors
 * Period:	4th
 * </pre>
 *
 * Summary of file: Write a program to assign two integer values to two variables num1 and num2.
 * Then calculate and assign to variables the sum, difference, product, integer quotient, decimal
 * quotient, integer modulus value, and decimal modulus value for the two integers. Indent output 20
 * spaces and format output exactly as shown below. Make the program run for two sets of values,
 * reassigning the variables used in the first output with the second set of data values, and then
 * reassigning all results to create the second output.
 *
 */
class MathOps {
    public static void main(String[] args) {
        final String HEADER = "****.****.****.****.*";
        int num1 = 12;
        int num2 = 5;
        int sum = num1 + num2;
        int prod = num1 - num2;
        int diff = num1 * num2;
        int quot = num1 / num2;
        double decQuot = num1 / (double) num2;
        int mod = num1 % (int) num2;
        double decMod = num1 % (double) num2;
        System.out.println(HEADER);
        System.out.printf("%20s%d + %d = %d\n", "", num1, num2, sum);
        System.out.printf("%20s%d - %d = %d\n", "", num1, num2, prod);
        System.out.printf("%20s%d * %d = %d\n", "", num1, num2, diff);
        System.out.printf("%20s%d / %d = %d\n", "", num1, num2, quot);
        System.out.printf("%20s%d / %.1f = %.2f\n", "", num1, (double) num2, decQuot);
        System.out.printf("%20s%d %% %d = %d\n", "", num1, num2, mod);
        System.out.printf("%20s%d %% %.1f = %.2f\n", "", num1, (double) num2, decMod);
        num1 = 256;
        num2 = 17;
        sum = num1 + num2;
        prod = num1 - num2;
        diff = num1 * num2;
        quot = num1 / num2;
        decQuot = num1 / (double) num2;
        mod = num1 % (int) num2;
        decMod = num1 % (double) num2;
        System.out.println();
        System.out.println(HEADER);
        System.out.printf("%20s%d + %d = %d\n", "", num1, num2, sum);
        System.out.printf("%20s%d - %d = %d\n", "", num1, num2, prod);
        System.out.printf("%20s%d * %d = %d\n", "", num1, num2, diff);
        System.out.printf("%20s%d / %d = %d\n", "", num1, num2, quot);
        System.out.printf("%20s%d / %.1f = %.2f\n", "", num1, (double) num2, decQuot);
        System.out.printf("%20s%d %% %d = %d\n", "", num1, num2, mod);
        System.out.printf("%20s%d %% %.1f = %.2f\n", "", num1, (double) num2, decMod);
    }
}
