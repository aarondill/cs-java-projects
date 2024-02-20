import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class Justin
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Author3: Daniel Behringer
 * Author4: Christian Adusei
 * Date:	February 08, 2023
 * </pre>
 *
 * Summary of file:
 * 
 * Calculate the monthly payment amount, total final cost, and total interest
 * [aid on a loan for a
 * car, given purchase price, down payment amount, percent APR, and the total
 * number of monthly
 * payments to be made
 *
 */
class Justin {
    /**
     * @return the monthly payment to 2 decimal places
     */
    private static double calculateMonthlyPayment(double purchasePrice, double downPayment,
            double percentAPR, double numberOfMonthlyPayments) {
        double decimalAPR = percentAPR / 100;
        double monthlyInterestRate = 1 / 12.0 * decimalAPR;
        double loanAmount = purchasePrice - downPayment;
        double numerator = loanAmount * monthlyInterestRate;
        double denominator = 1 - Math.pow(1 + monthlyInterestRate, -numberOfMonthlyPayments);
        return Math.round((numerator / denominator) * 100.0) / 100.0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner dataScanner = new Scanner(new File("./justin.dat"));
        int dataCount = dataScanner.nextInt();
        dataScanner.nextLine();
        for (int i = 0; i < dataCount; i++) {
            double purchasePrice = dataScanner.nextDouble();
            double downPayment = dataScanner.nextDouble();
            double percentAPR = dataScanner.nextDouble();
            int numberOfMonthlyPayments = dataScanner.nextInt();

            double monthlyPaymentAmount = calculateMonthlyPayment(purchasePrice, downPayment,
                    percentAPR, numberOfMonthlyPayments);
            double totalOfPayments = monthlyPaymentAmount * numberOfMonthlyPayments;
            double finalCost = downPayment + totalOfPayments;
            double interestPaid = finalCost - purchasePrice;

            System.out.printf("$%9.2f $%9.2f $%9.2f\n", monthlyPaymentAmount, finalCost,
                    interestPaid);
        }
    }
}
