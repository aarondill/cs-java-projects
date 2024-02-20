import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.function.Supplier;
import NiceScanner.ScannerUtils;

final public class Util extends ScannerUtils {
    /**
     * calls {@link PrintStream#print} on {@link System#out} then returns the
     * result of calling cb. No error checking is performed.
     */
    public static <T> T getData(String prompt, Supplier<T> cb) {
        System.out.print(prompt);
        return cb.get();
    }

    /**
     * Calls cb x times with the loop index as a {@link Integer} parameter
     * 
     * @param x Number of times to repeat
     * @param cb Callback function called each iteration
     */
    public static void repeat(int x, Consumer<Integer> cb) {
        for (int i = 0; i < x; i++) {
            cb.accept(i);
            if (i < x - 1)
                System.out.println();
        }
    }

    /**
     * Calls cb x times without a parameter. Identical to
     * {@link #repeat(int, Consumer)} except that the index is not passed
     * 
     * @param x Number of times to repeat
     * @param cb Callback function called each iteration
     */
    public static void repeat(int x, Runnable cb) {
        for (int i = 0; i < x; i++) {
            cb.run();
            if (i < x - 1)
                System.out.println();
        }
    }

    /** This class is not meant to be instantiated. use the static methods. */
    private Util() {};
}
