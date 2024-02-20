
package NiceScanner;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;

/**
 * A static class that provides utility methods for getting user input
 * <p>
 * Example using the generic {@link #getInput} method:
 * </p>
 * 
 * <pre>
 * {@code
 * Scanner scan = new Scanner(System.in)
 * Optional<Double> maybeGPA = ScannerUtils.getInput("Please enter your GPA: ",
 *         scan::hasNextDouble, scan::nextDouble, scan::nextLine);
 * double userGPA = maybeGPA.get();
 * }
 * </pre>
 */
public class ScannerUtils {
    private static void outputIfNotNull(String prompt) {
        if (prompt != null) // only if prompt is not null
            System.out.print(prompt); // Output the prompt
    }

    /**
     * Returns input from getData, provided hasData returns true, printing to
     * standard output the prompt each time hasData is called. If hasData
     * returns false, clearData is called to clear the previous input and the
     * function starts over.
     *
     * @param <T> The return type of {@code getData}
     * @param prompt A string to output to standard output each iteration. If
     *        prompt is {@code null}, nothing will be output.
     * @param hasData A function that returns true if {@code getData} will
     *        return a value, or false if {@code getData} should not be called.
     *        If {@code hasData} is {@code null}, {@code getData} will be called
     *        on the first iteration.
     * @param getData A function that returns the value desired. only called
     *        when {@code hasData} returns true.
     * @param clearData A function to be called every time {@code getData}
     *        returns false. If {@code clearData} is null, it will not be called
     *        on every iteration
     * @return A {@link Optional#empty()} if {@code hasData}, {@code getData} or
     *         {@code clearData} throw, or getData returns {@code null}, else an
     *         {@link Optional} containing the return of {@code getData}.
     */
    public static <T> Optional<T> getInput(String prompt,
            Supplier<Boolean> hasData, Supplier<T> getData,
            Runnable clearData) {
        outputIfNotNull(prompt);

        try {
            if (hasData == null || hasData.get()) // Don't call if hasData == null
                return Optional.ofNullable(getData.get()); // Return the data.
            if (clearData != null) // Don't run if null is passed
                clearData.run(); // Clear the input
        } catch (Exception e) {
            return Optional.empty(); // If something throws, return an empty optional
        }
        return getInput(prompt, hasData, getData, clearData); // prompt again
    }

    /* Gets the input from the scanner, like getInput */
    private static <T> Optional<T> getFromScanner(String prompt,
            Supplier<Boolean> hasData, Supplier<T> getData,
            Runnable clearData) {
        outputIfNotNull(prompt);
        try {
            if (hasData.get())
                return Optional.ofNullable(getData.get()); // Return the data.
            clearData.run(); // Clear the input - Throws if no more data is available
        } catch (NoSuchElementException e) {
            return Optional.empty(); // If something throws, return an empty optional
        }
        return getFromScanner(prompt, hasData, getData, clearData); // prompt again
    }

    /**
     * Returns a Optional<Double> from the scanner. The optional will only be
     * empty if the input is ended, or something throws.
     *
     * @param prompt A string to output to standard output each iteration. If
     *        prompt is {@code null}, nothing will be output.
     * @param scan A scanner to get the double input from.
     * @return A {@link Optional#empty()} if the input is ended before a double
     *         is inputted (at the start of a line) else an {@link Optional}
     *         containing a {@link Double}
     */
    public static Optional<Double> getDouble(String prompt, Scanner scan) {
        return getFromScanner(prompt, scan::hasNextDouble, scan::nextDouble,
                scan::nextLine);
    }

    /**
     * Returns a Optional<Integer> from the scanner. The optional will only be
     * empty if the input is ended, or something throws.
     * 
     * @see #getDouble(String, Scanner)
     */
    public static Optional<Integer> getInt(String prompt, Scanner scan) {
        return getFromScanner(prompt, scan::hasNextInt, scan::nextInt,
                scan::nextLine);
    }

    /**
     * Returns a Optional<Float> from the scanner. The optional will only be
     * empty if the input is ended, or something throws.
     * 
     * @see #getDouble(String, Scanner)
     */
    public static Optional<Float> getFloat(String prompt, Scanner scan) {
        return getFromScanner(prompt, scan::hasNextFloat, scan::nextFloat,
                scan::nextLine);

    }

    /**
     * Returns a Optional<Long> from the scanner. The optional will only be
     * empty if the input is ended, or something throws.
     * 
     * @see #getDouble(String, Scanner)
     */
    public static Optional<Long> getLong(String prompt, Scanner scan) {
        return getFromScanner(prompt, scan::hasNextLong, scan::nextLong,
                scan::nextLine);

    }

    /**
     * Returns a Optional<Boolean> from the scanner. The optional will only be
     * empty if the input is ended, or something throws.
     * 
     * @see #getDouble(String, Scanner)
     */
    public static Optional<Boolean> getBoolean(String prompt, Scanner scan) {
        return getFromScanner(prompt, scan::hasNextBoolean, scan::nextBoolean,
                scan::nextLine);
    }

    /**
     * The visibility of this constructor is protected so child classes can call
     * it. DON'T.
     */
    protected ScannerUtils() {};
}
