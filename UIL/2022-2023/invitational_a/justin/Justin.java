import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class Justin
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Author3: Evan Sao
 * Date:	February 21, 2023
 * </pre>
 *
 * Summary of file:
 * 
 * For each car, calculate and display the monthly payment, final cost which is
 * the total of all
 * payments plus the down payment, and the amount of interest paid which is the
 * total of payments
 * less the purchase price.
 * 
 */
class Justin {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner dataScanner = new Scanner(new File("./justin.dat"));
        int dataCount = dataScanner.nextInt();
        dataScanner.nextLine();
        for (int i = 0; i < dataCount; i++) {
            double purchasePrice = dataScanner.nextDouble();
            double downPayment = dataScanner.nextDouble();
            double percentAPR = dataScanner.nextDouble();
            int numberOfMonthlyPayments = dataScanner.nextInt();

            double monthlyPaymentAmount = 0;
            double totalOfPayments = 0;
            double finalCost = 0;
            double interestPaid = 0;

            System.out.printf("$%9.2f $%9.2f $%9.2f\n", monthlyPaymentAmount, finalCost,
                    interestPaid);
            // This was never finished. This is equivalent to `void ...` in JS
            assert "" + purchasePrice + downPayment + percentAPR + numberOfMonthlyPayments + totalOfPayments != null;
        }
    }
}
