/*
 * Import java.util.Calendar for later use in getting a date string representing
 * the current time and date
 */
import java.util.Calendar;
/*
 * Import java.util.Scanner for later use in "scanning" stdin for user input to
 * determine the parameters of the program.
 */
import java.util.Scanner;
/*
 * Import java.util.function.Supplier for use in the getInput(String, Supplier)
 * method to allow the passing of arrow functions (`x -> x+1`) and methods from
 * classes using the method reference operator (`class::method`)
 */
import java.util.function.Supplier;
/*
 * Import java.io.File and java.io.IOException for use in file operations (specifically read) and error "handling" respectively
 */
import java.io.File;
import java.io.IOException;
/**
 * Class Lab3A4
 *
 * <pre>
 * Author:	Aaron Dill
 * Date:	April 12, 2023
 * Course:	Computer Science I Honors
 * Period:	4th
 * </pre>
 *
 * Summary of file: This lab inputs from a file receipt items and outputs
 * them in the same format as the previous lab, first encountered in Lesson One,
 * and then again with variables in Lesson Two.
 */
public class Lab3B4 {
    /*
     * Create a private utility method `getInput` that receives a prompt to
     * ignore (treats like a comment) and a Supplier (java.util.function.Supplier), which
     * accepts no arguments and returns a value of generic type `T`, which is
     * then returned to the caller, allowing for one method to function for any
     * method return type the user needs, and improving readability and DX.
     */
    private static <T> T getInput(String prompt, Supplier<T> getData) {
        return getData.get();
    }

    /*
     * Define the main method that will be called by the JVM. The traditional
     * `String[] args` is replaced with a varargs array `String... args` to
     * increase compatibility with outside code and improve DX, however, as
     * passing an array of Objects to a varargs declaration with no additional
     * arguments is treated the same as a call with each individual argument,
     * this makes no difference in the compilation or running of the class
     * through the JVM.
     */
    public static void main(String... args) throws IOException {
        /*
         * Create an int called `spacing` for use in changing the column width in one centralized location
         */
        final int spacing = 50;
        /*
         * Initialize the variables that will be assigned in the
         * try-with-resources block, so that they will be accessible from the
         * outside scope. These include 3 items creatively titled item{1..3} and
         * three prices titled in the same way (price{1..3}).
         */
        String item1, item2, item3;
        double price1, price2, price3;
        /* Create a Calendar called today to get the date string from later */
        Calendar today = Calendar.getInstance();

        /*
         * The try-with-resources statement will create a resource (the Scanner)
         * and make it available within the block, automatically closing it
         * after the block ends or throws.
         */
        try (Scanner scan = new Scanner(new File("lab3b4.in"))) {
            // Input
            /*
             * Getting the first item's description from stdin using a custom
             * getInput method which takes a String prompt and a method to call
             * to get the input. This is functionally the same as calling
             * System.out.print("Enter first item description...");
             * scan.nextLine();
             */
            item1 = getInput("Enter first item description...", scan::nextLine);
            /*
             * Doing the same as above for but price number 1, receiving a
             * double
             */
            price1 = getInput("Enter first item price...", scan::nextDouble);
            /*
             * Advance the scanner to the next line, discarding the remaining
             * characters on the current line (presumably just whitespace)
             */
            scan.nextLine();
            /* Do all of the above another time */
            item2 = getInput("Enter next item description...", scan::nextLine);
            price2 = getInput("Enter next item price...", scan::nextDouble);
            scan.nextLine();
            /*
             * Do the same as above, but don't advance to the next line at the
             * end, as the scanner is discarded after this, and thusly, the
             * state doesn't matter
             */
            item3 = getInput("Enter last item description...", scan::nextLine);
            price3 = getInput("Enter last item price...", scan::nextDouble);
            /*
             * Completely redundant {@link Scanner#close()}, because the
             * try-with-resources (since Java 7) will close it automatically on
             * the very next line. See also: <code> interface {@link Closeable}
             * (extends {@link AutoCloseable}) </code>
             */
            scan.close();
        }

        // Processing
        /* Assign the sum of all three prices to a double called subtotal */
        double subtotal = price1 + price2 + price3;
        /*
         * Assign the product the subtotal and a fixed 8.25% tax rate to a double called tax
         */
        double tax = subtotal * 0.0825;
        /*
         * Assign the sum of subtotal and the tax to a new double called total
         */
        double total = subtotal + tax;

        // Output
        /*
         * Use the PrintStream.printf(String, Object...) method to output my
         * full name (middle initial) followed by a space, a dash, and a space,
         * and finally the calendar instance created at the beginning of the
         * main method representing the current date formatted using `%tc` to
         * output the full date with all information associated with it.
         * Followed by a new line.
         */
        System.out.printf("Aaron J Dill - %tc\n", today);
        /*
         * Use the PrintStream.println(String) method to output the word Receipt
         * wrapped in double quotes, followed by a space and the word Lab
         */
        System.out.println("\"Receipt\" Lab");
        /*
         * Use the PrintStream.printf(String, Object...) method to output nine
         * spaces by passing an empty string to the `%9s` format specifier and
         * following it by the words "The Random Store" and a newline
         */
        System.out.printf("%"+(int)spacing/2.5+"sThe Random Store\n", "");
        /*
         * Use the PrintStream.printf(String, Object...) method to output the
         * word Item followed by twenty spaces (done by reserving 18 spaces for
         * an empty string and placing spaces on either side of it (( for
         * readability)) ) and then the word Amount followed by a newline
         */
        System.out.printf("Item%"+spacing+"sAmount\n", "");
        /*
         * Use the PrintStream.printf(String, Object...) method to output item1
         * left aligned, with spacing+4 spaces reserved for it using `%-24s` and then
         * outputting a dollar sign followed by price1 right aligned with 6
         * spaces reserved and rounded to the nearest hundredth and finally a
         * newline character.
         */
        System.out.printf("%-"+(spacing + 4)+"s$%6.2f\n", item1, price1);
        /* Do the same as above but with item2 and price2 */
        System.out.printf("%-"+(spacing + 4)+"s$%6.2f\n", item2, price2);
        /* Do the same as above but with item3 and price3 */
        System.out.printf("%-"+(spacing + 4)+"s$%6.2f\n", item3, price3);
        /* Use the PrintStream.println() method to output an empty line to stdout */
        System.out.println();
        /*
         * Use the PrintStream.printf(String, Object...) method to output the
         * word Subtotal left aligned with 24 spaces reserved for it, then a
         * dollar sign and the value stored in the subtotal double right aligned
         * with 6 spaces reserved and rounded to the nearest hundredth
         */
        System.out.printf("%-"+(spacing + 4)+"s$%6.2f\n", "Subtotal", subtotal);

        /*
         * Use the PrintStream.printf(String, Object...) method to output the
         * word Tax left aligned with 24 spaces reserved for it, then a dollar
         * sign and the value stored in the tax double right aligned with 6
         * spaces reserved and rounded to the nearest hundredth
         */
        System.out.printf("%-"+(spacing + 4)+"s$%6.2f\n\n", "Tax", tax);

        /*
         * Use the PrintStream.printf(String, Object...) method to output the
         * word Total left aligned with 24 spaces reserved for it, then a dollar
         * sign and the value stored in the total double right aligned with 6
         * spaces reserved and rounded to the nearest hundredth
         */
        System.out.printf("%-"+(spacing + 4)+"s$%6.2f\n", "Total", total);
    }
}
