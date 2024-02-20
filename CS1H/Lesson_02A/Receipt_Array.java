import java.util.Calendar;

/**
 * Class Receipt_Array
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
class Receipt_Array {
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
        class Item {
            public String name;
            public double price;

            Item(String name, double price) {
                this.name = name;
                this.price = price;
            }
        }
        Item[] items = { new Item("20 Sided Die", 8.82),
                new Item("Two Sided Coin", 1.23),
                new Item("Color Spinner", 3.99) };
        double subtotal = 0;
        for (Item item : items) {
            System.out.printf("%-24s$%6.2f\n", item.name, item.price);
            subtotal += item.price;
        }
        System.out.println();

        System.out.printf("%-24s$%6.2f\n", "Subtotal", subtotal);

        double tax = subtotal * 0.08;
        System.out.printf("%-24s$%6.2f\n\n", "Tax", tax);

        System.out.printf("%-24s$%6.2f\n", "Total", subtotal + tax);
    }
}
