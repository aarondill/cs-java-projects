import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class Damian
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Author3: Evan Sao
 * Date:	February 08, 2023
 * </pre>
 *
 * Summary of file:
 * 
 * Input: Input will consist of an integer N, the number of test cases. The
 * number of test cases
 * will be in range [1,20]. Each subsequent line will contain an integer in the
 * range[1,1000000].
 * 
 * Output: Each line of output will be a line of "growing factors" listed in
 * ascending order with a
 * space between each number.
 * 
 */
class Damian {
    private static Set<Integer> findFactors(int product) {
        Set<Integer> factors = new TreeSet<Integer>();
        for (int i = 1; i < product; i++) {
            if (product % i == 0)
                factors.add(i);
        }
        return factors;
    }

    private static boolean isGrowing(int factor) {
        int decrement = factor;
        while (decrement >= 10) {
            int rightDigit = decrement % 10; // Gets rightmost digit
            decrement = decrement / 10; // removes rightmost digit
            int leftDigit = decrement % 10; // gets next rightmost digit
            if (rightDigit <= leftDigit) {
                return false;
            }
        }
        return true;
    }

    private static Set<Integer> findGrowing(Set<Integer> factors) {
        Set<Integer> growingFactors = new TreeSet<>();
        for (int factor : factors) {
            if (isGrowing(factor))
                growingFactors.add(factor);
        }
        return growingFactors;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner dataScanner = new Scanner(new File("./damian.dat"));
        int testCases = dataScanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int product = dataScanner.nextInt();
            Set<Integer> factors = findFactors(product);
            Set<Integer> growing = findGrowing(factors);
            for (int g : growing) {
                System.out.printf("%d ", g);
            }
            System.out.println();
        }
        dataScanner.close();
    }
}
