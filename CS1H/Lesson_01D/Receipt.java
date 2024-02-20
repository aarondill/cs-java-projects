import java.util.Calendar;

/**
 * Class Receipt
 *
 *
 * Author1: Aaron Dill
 * Author2: None
 * Date: January 09, 2023
 * Course: Computer Science I Honors
 *
 *
 * Summary of file:
 * Write a program that outputs a receipt from a store, with at least two but no
 * more than three items. The output should resemble the receipt as closely as
 * possible, with all dollar amounts preceded by the ‘$’ sign and properly
 * aligned at the decimal point. Include subtotal, tax, and grand total at the
 * bottom.
 *
 */
class Receipt {
    /**
     * <pre>
     * Output:
     * Aaron Dill - Thu Jan 06 09:38:54 CST 2022
     * "Receipt lab"
     *  
     * Item                 Amount
     * 20 Sided Die         $ 8.82
     * Two Sided Coin       $ 1.23
     * Color Spinner        $ 3.99
     *
     * Subtotal             $ 14.04
     * Tax                  $ 1.12
     *
     * Total                $ 518.41
     * </pre>
     */
    public static void main(String[] args) {
        Calendar today = Calendar.getInstance();
        printN(today, "The Random Store\n");
        printH();
        printI("20 Sided Die", 8.82);
        printI("Two Sided Coin", 1.23);
        printI("Color Spinner", 3.99);
        System.out.println();
        System.out.printf(
                "%s\t\t$%6.2f\n",
                "Subtotal",
                (+(+8 + 3 + 1) +
                        +(+0.99 + 0.82 + 0.23)));
        System.out.printf(
                "%s\t\t\t$%6.2f\n",
                "Tax",
                (+(+8 + 3 + 1) +
                        +(+0.99 + 0.82 + 0.23)) *
                        (+8 / +100));
        System.out.printf(
                "%s\t\t\t$%6.2f\n",
                "Total",
                (+(+8 + 3 + 1) +
                        +(+0.99 + 0.82 + 0.23)) +
                        +((+8 + 3 + 1) +
                                +(+0.99 + 0.82 + 0.23))
                                * (+8 / 100));
    }

    /**
     * Print my name and the date inputted.
     * 
     * @param today The `current` date
     */
    public static void printN(Calendar today, String storeName) {
        System.out.printf("Aaron J Dill - %tc\n", today);
        System.out.println("\"Receipt Lab\"");
        System.out.println(storeName);
    }

    /**
     * Print the headers
     */
    public static void printH() {
        System.out.println("Item\t\t\tAmount");
    }

    /**
     * Print the item passed in with the price defined
     * 
     * @param item  the item to print
     * @param price the price to print
     */
    public static void printI(String item, double price) {
        System.out.printf("%s\t\t$%6.2f\n", item, price);
    }
}
