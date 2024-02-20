import java.util.Scanner;
import java.util.function.Supplier;
import java.io.IOException;
import java.io.File;

/**
 * Class Lab3B5
 *
 * <pre>
 * Author:	Aaron Dill
 * Date:	April 12, 2023
 * Course:	Computer Science I Honors
 * Period:	4th
 * </pre>
 *
 * Summary of file:
 * This lab inputs from a file a number of seconds and outputs the
 * equivalent number of minutes and remaining seconds.
 */
public class Lab3B5 {
    /** prompt is ignored! */
    private static <T> T getInput(String prompt, Supplier<T> getData) {
        return getData.get();
    }

    public static void main(String[] args) throws IOException{
        try (Scanner scan = new Scanner(new File("lab3b5.in"))) {
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
                if(i<ITERATIONS-1) System.out.println();
            }

        }
    }
}
