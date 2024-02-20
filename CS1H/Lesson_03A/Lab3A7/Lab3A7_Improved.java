import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Supplier;

/**
 * Class Lab3A7
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    March 29, 2023
 * Course:  Computer Science I Honors
 * Period:  4th
 * </pre>
 *
 * Summary of file: WAP to “make change” for a double input value, such as
 * 388.97(38897 pennies), to the smallest possible number of bills and coins. Do
 * NOT use half-dollars or two-dollar bills. You must use / and % to
 * mathematically accomplish this task. Run your program a second time to
 * convert the input value 412.42. Make your program run with two sets of data,
 * indented and formatted exactly as shown below. Hint: Input the money value
 * into a double, multiply the value by 100, cast it into an integer that
 * represents the value in pennies, and then mathematically use / and % in
 * combination (see Lesson 2C) to calculate each denomination.
 */
public class Lab3A7_Improved {
    private static <T> T getData(String prompt, Supplier<T> cb) {
        System.out.print(prompt);
        return cb.get();
    }

    private static int sum(Integer... numbers) {
        return Arrays.stream(numbers).reduce(0, (a, b) -> a + b);
    }

    public static void run(Scanner kb) {
        // Input
        double dollars = getData("Enter a dollar amount...", kb::nextDouble);
        // Process
        int cents, centsLeft;
        centsLeft = cents = (int) (dollars * 100);

        int bens, grants, jacksons, hamiltons, lincolns, washingtons, quarters,
                dimes, nickels, pennies;

        centsLeft -= (bens = centsLeft / 100_00) * 100_00;
        centsLeft -= (grants = centsLeft / 50_00) * 50_00;
        centsLeft -= (jacksons = centsLeft / 20_00) * 20_00;
        centsLeft -= (hamiltons = centsLeft / 10_00) * 10_00;
        centsLeft -= (lincolns = centsLeft / 5_00) * 5_00;
        centsLeft -= (washingtons = centsLeft / 1_00) * 1_00;
        centsLeft -= (quarters = centsLeft / 25) * 25;
        centsLeft -= (dimes = centsLeft / 10) * 10;
        centsLeft -= (nickels = centsLeft / 5) * 5;
        pennies = centsLeft;

        int items = sum(bens, grants, jacksons, hamiltons, lincolns,
                washingtons, quarters, dimes, nickels, pennies);

        // Output
        System.out.println("****.****.****.****.****.");
        System.out.printf("%13s$%.2f = %d cents\n", "", dollars, cents);
        System.out.printf("%21s = %d Benjamin(s) - hundred\n", "", bens);
        System.out.printf("%21s = %d Grant(s) - fifty\n", "", grants);
        System.out.printf("%21s = %d Jackson(s) - twenty\n", "", jacksons);
        System.out.printf("%21s = %d Hamilton(s) - ten\n", "", hamiltons);
        System.out.printf("%21s = %d Lincoln(s) - five\n", "", lincolns);
        System.out.printf("%21s = %d Washington(s)- one\n", "", washingtons);
        System.out.printf("%21s = %d Quarter(s)\n", "", quarters);
        System.out.printf("%21s = %d Dime(s)\n", "", dimes);
        System.out.printf("%21s = %d Nickel(s)\n", "", nickels);
        System.out.printf("%21s = %d Pennies(s)\n", "", pennies);
        System.out.printf("%13s%d money items in all\n", "", items);
    }

    public static void main(String[] args) {
        try (Scanner kb = new Scanner(System.in)) {
            final int ITERATIONS = 2;
            for (int i = 0; i < ITERATIONS; i++) {
                run(kb);
                if (i < ITERATIONS - 1)
                    System.out.println();
            }
        }
    }
}
