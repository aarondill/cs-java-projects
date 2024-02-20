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
 * This time with variables
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
        System.out.printf("Aaron J Dill - %tc\n", today);
        System.out.println("\"Receipt Lab\"");
        System.out.printf("%9sThe Random Store\n\n", "");
        System.out.printf("Item %18s Amount\n", "");

        String item1 = "20 Sided Die";
        String item2 = "Two Sided Coin";
        String item3 = "Color Spinner";
        double price1 = 8.82;
        double price2 = 1.23;
        double price3 = 3.99;
        System.out.printf("%-24s$%6.2f\n", item1, price1);
        System.out.printf("%-24s$%6.2f\n", item2, price2);
        System.out.printf("%-24s$%6.2f\n", item3, price3);
        System.out.println();

        double subtotal = price1 + price2 + price3;
        System.out.printf("%-24s$%6.2f\n", "Subtotal", subtotal);

        double tax = subtotal * 0.08;
        System.out.printf("%-24s$%6.2f\n\n", "Tax", tax);

        System.out.printf("%-24s$%6.2f\n", "Total", subtotal + tax);
    }
}
