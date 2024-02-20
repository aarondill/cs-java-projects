import java.util.Scanner;
import java.util.function.Supplier;

/**
 * Class Lab3A5
 *
 * <pre>
 * Author:	Aaron Dill
 * Date:	March 29, 2023
 * Course:	Computer Science I Honors
 * Period:	4th
 * </pre>
 *
 * Summary of file:
 * This lab inputs from the keyboard a number of seconds and outputs the
 * equivalent number of minutes and remaining seconds.
 */
public class Lab3A5 {
    private static <T> T getInput(String prompt, Supplier<T> getData) {
        System.out.print(prompt);
        return getData.get();
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            final int ITERATIONS = 2;
            for (int i = 0; i < ITERATIONS; i++) {
                int seconds, min, sec;
                // Input
                seconds = getInput("Enter seconds...", scan::nextInt);
                // Processing
                min = seconds / 60; // Integer division!
                sec = seconds % 60;
                // Output31987
                System.out.println("****.****.***");
                System.out.printf("%12s%d seconds = %d minutes and %d seconds\n", "", seconds, min, sec);
                System.out.println();
            }

        }
    }
}
