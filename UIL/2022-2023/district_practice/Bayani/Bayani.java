import java.util.Scanner;

/**
 * Class Bayani
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Date:	March 23, 2023
 * </pre>
 *
 * Summary of file:
 * print a report of bill expenses for the month so far according to input.
 *
 */

public class Bayani {
    public static void main(String[] args) {
        Scanner datScan = new Scanner(Bayani.class.getResourceAsStream("./bayani.dat"));
        double total = 0;
        while (datScan.hasNextDouble()) {
            double i = datScan.nextDouble();
            total += i;
            System.out.printf("\t$%7.2f\n", i);
        }
        System.out.printf("Total = $%7.2f\n", total);
    }
}
